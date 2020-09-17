package com.example.batchpoc;

import com.example.batchpoc.domain.Provider;
import com.example.batchpoc.processor.ProviderProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableScheduling
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public RowMapper<Provider> providerRowMapper;

    @Autowired
    public ProviderProcessor providerProcessor;

    @Autowired
    public DataSource dataSource;

    @Autowired
    JobLauncher jobLauncher;

    /*@Scheduled(fixedRate = 10000)
    public void perform() throws Exception
    {
        jobLauncher.run(sampleJob1(), new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .addDate("date", new Date())
                .toJobParameters());
    }*/

    @Bean
    public Job sampleJob1() throws Exception {
        System.out.println("EXCECUTING JOB");
        return this.jobBuilderFactory.get("sampleJob1")
                .incrementer(new RunIdIncrementer())
                .start(step1(itemReader(queryProvider()),writer()))
                .build();
    }
    @Bean
    public Step step1( JdbcPagingItemReader<Provider> reader, JdbcBatchItemWriter<Provider> writer) throws Exception {
        System.out.println("EXCECUTING STEP");
        return stepBuilderFactory.get("step1")
                .<Provider, Provider> chunk(10)
                .reader(reader)
                .processor(providerProcessor)
                .writer(writer)
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<Provider> writer() {
        System.out.println("NEW WRITER "+System.currentTimeMillis());
        return new JdbcBatchItemWriterBuilder<Provider>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO events (event) VALUES (:firstName)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public JdbcPagingItemReader itemReader(PagingQueryProvider queryProvider) throws Exception {
        System.out.println("NEW READER");
        Map<String, Object> parameterValues = new HashMap<>();
        parameterValues.put("id", "0");

        JdbcPagingItemReader<Provider> s = new JdbcPagingItemReaderBuilder<Provider>()
                .name("ProviderReader")
                .dataSource(dataSource)
                .queryProvider(queryProvider)
                .parameterValues(parameterValues)
                .rowMapper(providerRowMapper)
                .pageSize(1000)
                .build();
        return s;
    }

    @Bean
    public PagingQueryProvider queryProvider() throws Exception {
        SqlPagingQueryProviderFactoryBean provider = new SqlPagingQueryProviderFactoryBean();

        provider.setDataSource(dataSource);
        provider.setSelectClause("select *");
        provider.setFromClause("from provider");
        provider.setWhereClause("where id>:id");
        provider.setSortKey("id");

        System.out.println(provider.getObject().getSortKeys());

        return provider.getObject();
    }



}

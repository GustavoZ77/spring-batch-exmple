package com.w2o.batchpoc;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@SpringBootApplication
@EnableBatchProcessing
@EnableTask
public class JseDataLayerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JseDataLayerApiApplication.class, args);
	}

}

package com.w2o.batchpoc.processor;

import com.w2o.batchpoc.domain.Provider;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service("providerRowMapper")
public class ProviderMapper implements RowMapper<Provider> {

    @Override
    public Provider mapRow(ResultSet rs, int rowNum) throws SQLException {

        Provider provider = new Provider();

        provider.setId(rs.getLong("id"));
        provider.setAge(rs.getInt("age"));
        provider.setFirstName(rs.getString("firstname"));
        provider.setLastName(rs.getString("lastname"));
        provider.setGender(rs.getString("gender"));
    return provider;
    }
}

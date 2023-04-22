package com.rajamarul.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.JDBCType;
import java.sql.Types;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;


     @Bean("dataSource1")
    public DataSource getDataSourceSQL() {
        DataSource dataSource = new DriverManagerDataSource(url,userName,password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource1) {
        return new JdbcTemplate(dataSource1);
    }

    @Bean
    public SimpleJdbcCall simpleJdbcCall(DataSource dataSource1) {
         return new SimpleJdbcCall(dataSource1)
                 .withProcedureName("read_employee")
                 .withoutProcedureColumnMetaDataAccess()
                 .useInParameterNames("in_employeeId")
                 .declareParameters(
                         new SqlParameter("in_employeeId", Types.INTEGER),
                         new SqlOutParameter("out_name",Types.CHAR),
                         new SqlOutParameter("out_age",Types.INTEGER),
                         new SqlOutParameter("out_salary",Types.INTEGER));

    }


    /// Another way of dataSource Creation:

   /* @Bean("sqlDataSource")
    @ConfigurationProperties(prefix = "sql.dataSoiurce")
    public DataSource primaryDataSoiurce() {
         return DataSourceBuilder.create().build();
    }

    @Bean(name="sqlJdbcTemplate")
    public JdbcTemplate jdbcTemplate1(@Qualifier("sqlDataSource") DataSource dataSource) {
         return new JdbcTemplate(dataSource);
    }*/

}

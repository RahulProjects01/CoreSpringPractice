// Update package declaration in SpringConfigFile
package org.example.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfigFile {

    @Bean
    public DriverManagerDataSource myDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");  // MySQL driver
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc_db"); // Replace with your DB URL
        dataSource.setUsername("root"); // Replace with your DB username
        dataSource.setPassword("1234"); // Replace with your DB password

        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate npJdbcTemplate() {
        return new NamedParameterJdbcTemplate(myDataSource());
    }
}

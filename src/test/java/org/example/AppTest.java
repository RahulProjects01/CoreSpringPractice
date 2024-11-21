package org.example;

import org.example.resource.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

public class AppTest {
    public static void main(String[] args) {
        // Initialize Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);

        // Retrieve the NamedParameterJdbcTemplate bean
        NamedParameterJdbcTemplate npJdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);

        // Prepare the parameter map for the SQL query
        Map<String, Object> map = new HashMap<>();
        map.put("key_rollno", 104);
        map.put("key_name", "Rahul");
        map.put("key_marks", "23.22");

        // SQL Insert Query with named parameters
        String insert_sql_query = "INSERT INTO student (rollno, name, marks) VALUES (:key_rollno, :key_name, :key_marks)";

        // Execute the query
        int count = npJdbcTemplate.update(insert_sql_query, map);

        // Check if the insert was successful
        if (count > 0) {
            System.out.println("Insert Successful!");
        } else {
            System.out.println("Insert Failed!");
        }
    }
}

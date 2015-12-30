package com.zengcode.th;


import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;

@RestController
public class HelloController {

    @Autowired
    private ApplicationConfiguration applicationConfiguration;

   // private DataSource dataSource;

    //private JdbcTemplate jdbcTemplate;

    //@Autowired
    //public void setDataSource(DataSource dataSource) {
       // this.dataSource = dataSource;
    //}

    @RequestMapping("/")
    public String index() {
        return "Hello version 1.0.2";
          /*
        String sql = "select COUNT(*) from publication";

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.queryForObject(sql, Integer.class);*/
        //return "Greetings from Spring Boot! " + applicationConfiguration.getUsername() + " : " + applicationConfiguration.getServerConfiguration().getDev();
    }



}
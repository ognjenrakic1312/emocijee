package org.etsntesla.it.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class MySqlManagerBean {
    @Autowired
    @Qualifier("factoryDBConfig")
    private DatabaseConfiguration config;

    public Connection getConnection() {
        try{
        return DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPass()
        );


    }catch (SQLException e){
        throw new RuntimeException(e.getMessage());}
    }
}


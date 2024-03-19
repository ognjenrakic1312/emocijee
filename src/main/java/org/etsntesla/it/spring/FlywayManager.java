package org.etsntesla.it.spring;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlywayManager implements InitializingBean {

    @Autowired

    private DatabaseConfiguration   config;

    private Flyway flyway;

    public Flyway getFlyway() {
        return flyway;
    }
}

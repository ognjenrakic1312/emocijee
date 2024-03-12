package org.etsntesla.it;

import org.etsntesla.it.BaseMySqlTest;
import org.etsntesla.it.spring.BeanFactory;
import org.etsntesla.it.spring.MySqlManagerBean;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MySqlTest3 extends BaseMySqlTest {

    static ApplicationContext ctx;

    @BeforeAll
    static void init3() throws SQLException {
        ctx = new AnnotationConfigApplicationContext(BeanFactory.class);
        statement = ctx.getBean(MySqlManagerBean.class).getConnection().createStatement();
        setDataDumpMySqlFile("V01.002__emocije_data_dump.sql");
        setEmptyDumpMySqlFile("V01.001__emocije_drop_dump.sql");
        emptyData();
        fillData();
    }

    @Test
    void test() throws SQLException {
        statement.executeUpdate("DELETE FROM pitRakic WHERE id=4;");
    }

    @AfterAll
    static void showResult(){
        showTable();
        emptyData();
    }

}

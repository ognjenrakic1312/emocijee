package org.etsntesla.it;

import org.etsntesla.it.BaseMySqlTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class MySqlTest1 extends BaseMySqlTest {

    @BeforeAll
    static void init1(){
        setDataDumpMySqlFile("V01.002__emocije_data_dump.sql");
        setEmptyDumpMySqlFile("V01.001__emocije_drop_dump.sql");
        emptyData();
        fillData();
    }

    @Test
    void test() throws SQLException {
        statement.executeUpdate("INSERT INTO emocije VALUES(NULL,'Radost',\"Prije nego što krenete tražiti sreću, provjerite - možda ste već sretni\")");
    }

    @AfterAll
    static void showResult(){
        showTable();
        emptyData();
    }

}

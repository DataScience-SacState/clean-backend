package edu.csus.datascience.cleanbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.xml.crypto.Data;
import java.util.Map;

/**
 * Created by merrillm on 4/8/16.
 */
@SpringBootApplication
@ImportResource("classpath:Beans.xml")
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");


        SpringApplication.run(Application.class, args);
    }

}

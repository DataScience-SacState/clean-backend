package edu.csus.datascience.cleanbackend;

import edu.csus.datascience.cleanbackend.rest.EventJDBCTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by merrillm on 4/8/16.
 */
@SpringBootApplication
@ImportResource("classpath:Beans.xml")
public class Application {

    public static final ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    public static final EventJDBCTemplate eventJDBCTemplate = (EventJDBCTemplate)context.getBean("eventJDBCTemplate");

    public static boolean SILENT;
    public static void main(String[] args) throws IOException, ParseException {
        SILENT = (Arrays.stream(args).anyMatch(s -> s.equalsIgnoreCase("silent")));

        if (Arrays.stream(args).anyMatch(s -> s.equalsIgnoreCase("dbupdate"))) {
            DBUpdate.run();
            return;
        }

        SpringApplication.run(Application.class, args);
    }

}

package edu.csus.datascience.cleanbackend;

import edu.csus.datascience.cleanbackend.rest.Event;
import edu.csus.datascience.cleanbackend.rest.EventJDBCTemplate;
import edu.csus.datascience.cleanbackend.rest.IDIncrement;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by merrillm on 4/8/16.
 */
@SpringBootApplication
public class ApplicationTest {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        EventJDBCTemplate eventJDBCTemplate = (EventJDBCTemplate)context.getBean("eventJDBCTemplate");

        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=longasssqlpassword");
        //PreparedStatement ps = connection.prepareStatement("CREATE DATABASE cleandb");
        //int result = ps.executeUpdate();

        if (eventJDBCTemplate.listEvents().isEmpty()) {
            System.out.println("-----Records Creation-----");
            {
                eventJDBCTemplate.create(IDIncrement.nextEventId(), "Morty", "Dead Rick", "90.0", "45.5");
                eventJDBCTemplate.create(IDIncrement.nextEventId(), "Rick", "High Morty", "asfd", "asfas");
                eventJDBCTemplate.create(IDIncrement.nextEventId(), "Blue", "Skadoo", "alfalfa", "longydude");
            }
        }

        System.out.println("-----Listing Multiple Records-----");
        {
            List<Event> events = eventJDBCTemplate.listEvents();
            for (Event event : events) {
                printRecord(event);
            }
        }

        System.out.println("-----Updating Record with ID = _2-----");
        {
            eventJDBCTemplate.update("_2", "right-about-now");
        }

        System.out.println("-----Listing Record with ID = _2-----");
        {
            Event event = eventJDBCTemplate.getEvent("_2");
            printRecord(event);
        }
    }

    public static void printRecord(Event event) {
        System.out.printf("ID:'%s',\tReporter:'%s',\tDescription:'%s',\t" +
                "Latitude:'%s',\tLongitude:'%s'\tTimeReported:'%s'\tTimeCompleted:'%s'\n",
                event.getId(), event.getReporter(), event.getDescription(),
                event.getLatitude(), event.getLongitude(), event.getTimeReported(), event.getTimeCompleted());
    }

}

package edu.csus.datascience.cleanbackend;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.List;

/**
 * Created by merrillm on 4/8/16.
 */
public class EventJDBCTemplate implements EventDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(ds);
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public void create(String id, String reporter, String description, String latitude, String longitude) {
        String SQL = "insert into Event (id, reporter, description, latitude, longitude) values (?, ?, ?, ?, ?)";
        jdbcTemplateObject.update( SQL, id, reporter, description, latitude, longitude);
        System.out.printf("Created Record ID = %s Name = %s Description = '%s' Latitude = %s, Longitude = %s\n", id + "", reporter, description, latitude, longitude);
        return;
    }

    @Override
    public Event getEvent(String id) {
        String SQL = "select * from Event where id = ?";
        Event event = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new EventMapper());
        return event;
    }

    @Override
    public List<Event> listEvents() {
        String SQL = "select * from Event";
        List<Event> events = jdbcTemplateObject.query(SQL, new EventMapper());
        return events;
    }

    @Override
    public void delete(String id) {
        String SQL = "delete from Event where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.printf("Deleted Record with ID = %s\n", id);
        return;
    }

    @Override
    public void update(String id, String timeCompleted) {
        String SQL = "update Event set timeCompleted = ? where id = ?";
        jdbcTemplateObject.update(SQL, timeCompleted, id);
        System.out.printf("Updated Record with ID = %s\n", id);
        return;
    }
}

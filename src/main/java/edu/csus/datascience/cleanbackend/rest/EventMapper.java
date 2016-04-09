package edu.csus.datascience.cleanbackend.rest;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by merrillm on 4/8/16.
 */
public class EventMapper implements RowMapper<Event> {

    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event(rs.getString("id"));
        event.setReporter(rs.getString("reporter"));
        event.setDescription(rs.getString("description"));

        event.setLatitude(rs.getString("latitude"));
        event.setLongitude(rs.getString("longitude"));

        event.setTimeReported(rs.getString("timeReported"));
        event.setTimeCompleted(rs.getString("timeCompleted"));
        return event;
    }

}

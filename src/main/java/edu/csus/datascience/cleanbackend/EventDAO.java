package edu.csus.datascience.cleanbackend;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by merrillm on 4/8/16.
 */
public interface EventDAO {

    /**
     * Initialize database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * Return database resources for modification.
     */
    public DataSource getDataSource();

    /**
     * Create a record in Event table.
     */
    public void create(String id, String reporter, String description, String latitude, String longitude);

    /**
     * List record corresponding to passed Event id.
     */
    public Event getEvent(String id);

    /**
     * List all records from Event table.
     */
    public List<Event> listEvents();

    /*
     * Used to delete an Event from Event table.
     */
    public void delete(String id);

    /**
     * Used to update a record into Event table.
     */
    public void update(String id, String timeCompleted);

}

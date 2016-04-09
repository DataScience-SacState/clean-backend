package edu.csus.datascience.cleanbackend.rest;

/**
 * Created by merrillm on 4/8/16.
 */
public class Event {

    private String id;

    private String reporter;
    private String description;
    private String timeReported;

    private String latitude;
    private String longitude;

    private String timeCompleted;

    public Event() {
        id = IDIncrement.nextEventId();
    }

    public Event(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }
    public String getReporter() {
        return reporter;
    }

    public void setTimeReported(String timeReported) {
        this.timeReported = timeReported;
    }
    public String getTimeReported() {
        return timeReported;
    }

    public void setTimeCompleted(String timeCompleted) {
        this.timeCompleted = timeCompleted;
    }
    public String getTimeCompleted() {
        return timeCompleted;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLatitude() {
        return latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getLongitude() {
        return longitude;
    }
}

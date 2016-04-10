package edu.csus.datascience.cleanbackend.rest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by merrillm on 4/9/16.
 */
@RestController
public class EventController {

    private ApplicationContext context;
    private EventJDBCTemplate eventJDBCTemplate;

    {
        context = new ClassPathXmlApplicationContext("Beans.xml");
        eventJDBCTemplate = (EventJDBCTemplate)context.getBean("eventJDBCTemplate");
    }

    @RequestMapping(value={"/create", "/report"})
    public String create(
            @RequestParam(value="reporter", required=false, defaultValue="311") String reporter,
            @RequestParam(value="description", required=true) String description,
            @RequestParam(value="latitude", required=true) String latitude,
            @RequestParam(value="longitude", required=true) String longitude,
            Model model) {

        eventJDBCTemplate.create(IDIncrement.nextEventId(), reporter, description, latitude, longitude);

        return "success";
    }

    @RequestMapping("/list.json")
    public List<Event> list(
            @RequestParam(value="since", required=false) String since,
            Model model) {

        List<Event> list;
        if (since == null)
            list = eventJDBCTemplate.listEvents();
        else {
            eventJDBCTemplate.listEventsSince(since);
        }

        return eventJDBCTemplate.listEvents();
    }

    @RequestMapping(value={"/since", "/listsince"})
    public List<Event> listSince(
            @RequestParam(value="time", required=true) String time,
            Model model) {

        return eventJDBCTemplate.listEventsSince(time);
    }

    @RequestMapping("/delete")
    public String delete(
            @RequestParam(value="id", required=true) String id,
            Model model) {

        eventJDBCTemplate.delete(id);
        return "success";
    }
}

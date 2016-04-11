package edu.csus.datascience.cleanbackend;

import com.fasterxml.jackson.databind.JsonNode;
import edu.csus.datascience.cleanbackend.rest.Event;
import edu.csus.datascience.cleanbackend.rest.EventJDBCTemplate;
import org.json.JSONObject;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by merrillm on 4/9/16.
 */
public class DBUpdate {

    public static void run() throws IOException {
        EventJDBCTemplate eventJDBCTemplate = Application.eventJDBCTemplate;

        JsonParser jsonParser = new JsonJsonParser();
        StringBuilder sb = new StringBuilder();
        byte[] bytes = Files.readAllBytes(Paths.get("data.json"));
        for (byte b : bytes)
            sb.append((char)b);

        if (!Application.SILENT)
        System.out.println(sb.toString());

        List<Object> list = jsonParser.parseList(sb.toString()); // JUST DO IT
        for (Object obj : list) {
            Map<String, Object> map = (Map<String, Object>) obj;

            Event e;
            if (map.containsKey("CASE_NBR")) {
                e = new Event(map.get("CASE_NBR").toString());
            } else {
                e = new Event();
            }

            e.setLongitude(map.get("LON").toString());
            e.setLatitude(map.get("LAT").toString());

            e.setDescription(map.get("DESCRIPTION").toString());
            e.setType(map.get("TYPE").toString());
            e.setReporter("311");

            String time;
            try {
                String target = map.get("CREATED").toString();
                DateFormat df = new SimpleDateFormat("[M]M/[d]d/yyyy [h]h:[m]m:[s]s");
                Date date = df.parse(target);
                time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);
            } catch (Exception ex) {
                time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            }
            e.setTimeReported(time);
            e.setTimeCompleted(time);

            eventJDBCTemplate.update(e);
            System.out.println(map.toString());
        }
    }

}

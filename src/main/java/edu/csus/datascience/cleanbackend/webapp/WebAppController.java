package edu.csus.datascience.cleanbackend.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

import javax.xml.ws.ResponseWrapper;

/**
 * Created by merrillm on 4/9/16.
 */
@Controller
public class WebAppController {

    @RequestMapping("/webapp")
    public String root(Model model) {
        System.out.println("Hi!");
        System.out.println(model.asMap());
        return "index";

    }

}

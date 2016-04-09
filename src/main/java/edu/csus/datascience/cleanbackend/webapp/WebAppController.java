package edu.csus.datascience.cleanbackend.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by merrillm on 4/9/16.
 */
@Controller
public class WebAppController {

    @RequestMapping("/hello")
    public String root(Model model) {
        System.out.println("Hi!");
        return "index";
    }

}

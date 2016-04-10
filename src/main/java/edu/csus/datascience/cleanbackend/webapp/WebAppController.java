package edu.csus.datascience.cleanbackend.webapp;

import com.auth0.Auth0User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by merrillm on 4/9/16.
 */
@Controller
public class WebAppController {

    @RequestMapping("/webapp")
    public String root(Model model, HttpServletRequest req, HttpServletResponse res) {
        System.out.println("Hi!");
        System.out.println(Auth0User.get(req));

        try {
            model.addAttribute("name", Auth0User.get(req).getName());
        } catch (Exception e) {
            return "index";
        }

        return "greeting";

    }

}

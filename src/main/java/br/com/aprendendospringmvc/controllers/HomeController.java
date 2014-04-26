
package br.com.aprendendospringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ellison on 22/04/14.
 */
@Controller
public class HomeController {

    static final String CONTEXT_PATH = "/";
    static final String HOME = "home";

    @RequestMapping(value = CONTEXT_PATH + HOME)
    public String index() {
        return HOME;
    }

}

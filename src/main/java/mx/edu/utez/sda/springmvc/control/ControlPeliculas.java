package mx.edu.utez.sda.springmvc.control;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/movies")
public class ControlPeliculas {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @Secured({"ROLE_RECE","ROLE_CHILD", "ROLE_TEEN","ROLE_ADULT"})
    public String index() {
        return "movies";
    }
    @RequestMapping(value = "/child", method = RequestMethod.GET)
    @Secured({"ROLE_CHILD", "ROLE_ADULT"})
    public String child() {
        return "children";
    }
    @RequestMapping(value = "/adult", method = RequestMethod.GET)
    @Secured({"ROLE_ADULT"})
    public String adult() {
        return "adultos";
    }

}

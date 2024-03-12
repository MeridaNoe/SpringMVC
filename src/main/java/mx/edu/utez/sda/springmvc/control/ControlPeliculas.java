package mx.edu.utez.sda.springmvc.control;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/peliculas")
public class ControlPeliculas {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @Secured({"ROLE_RECE","ROLE_NINIO","ROLE_ADULTO"})
    public String index() {
        return "peliculas";
    }
    @RequestMapping(value = "/ninios", method = RequestMethod.GET)
    @Secured({"ROLE_NINIO", "ROLE_ADULTO"})
    public String child() {
        return "ninios";
    }

    @RequestMapping(value = "/adultos", method = RequestMethod.GET)
    @Secured("ROLE_ADULTO")
    public String adulto() {
        return "adultos";
    }





}

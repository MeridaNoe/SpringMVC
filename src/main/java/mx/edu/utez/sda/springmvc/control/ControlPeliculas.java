package mx.edu.utez.sda.springmvc.control;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/peliculas")
public class ControlPeliculas {


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @Secured({"ROLE_RECE", "ROLE_NINIO", "ROLE_ADULTO"}) //SPRING SECUITY SIEMPRE PONE AL ROL -> "ROLE_"
    public String index(){
        return "peliculas";
    }


    /*@RequestMapping(value = "/ninios",  method = RequestMethod.GET)
    @Secured({"ROLE_NINIO", "ROLE_ADULTO"})
    public String ninio(){
        return
    }*/
}

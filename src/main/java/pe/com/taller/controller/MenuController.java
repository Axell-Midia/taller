package pe.com.taller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/menuprincipal")
    public String mostrarMenuPrincipal() {
        return "menuprincipal";  
    }
}

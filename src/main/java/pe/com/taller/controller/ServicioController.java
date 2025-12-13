package pe.com.taller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.taller.entity.ServicioEntity;
import pe.com.taller.service.ServicioService;
@Controller
public class ServicioController {


    @Autowired
    private ServicioService servicio;

    @GetMapping("/servicio/listar")
    public String MostrarListarServicio(Model modelo) {
        modelo.addAttribute("listaservicio", servicio.findAllCustom());
        return "servicio/listar_servicio";
    }

    @GetMapping("/servicio/registro")
    public String MostrarRegistrarServicio(Model modelo) {
        return "servicio/registrar_servicio";
    }

    @GetMapping("/servicio/actualizar/{id}")
    public String MostrarActualizarServicio(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("servicio", servicio.findById(id));
        return "servicio/actualizar_servicio";
    }

    @GetMapping("/servicio/habilitar")
    public String MostrarHabilitarServicior(Model modelo) {
        modelo.addAttribute("listaservicio", servicio.findAll());
        return "servicio/habilitar_servicio";
    }

    @GetMapping("/servicio/eliminar/{id}")
    public String EliminarServicio(@PathVariable Long id) {
    	servicio.delete(id);
        return "redirect:/servicio/listar";
    }

    @GetMapping("/servicio/habilitar/{id}")
    public String HabilitarServicio(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/servicio/habilitar";
    }

    @GetMapping("/servicio/deshabilitar/{id}")
    public String DeshabilitarServicio(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/servicio/deshabilitar";
    }

    @ModelAttribute("servicio")
    public ServicioEntity ModeloServicio() {
        return new ServicioEntity();
    }

    @PostMapping("/servicio/registrar")
    public String RegistrarServicio(@ModelAttribute("servicio") ServicioEntity obj) {
        servicio.add(obj);
        return "redirect:/servicio/listar";
    }

    @PostMapping("/servicio/actualizar/{id}")
    public String ActualizarServicio(@ModelAttribute("servicio") ServicioEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/servicio/listar";
    }
}

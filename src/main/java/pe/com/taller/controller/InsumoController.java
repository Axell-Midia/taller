package pe.com.taller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.taller.entity.InsumoEntity;
import pe.com.taller.service.InsumoService;

@Controller
public class InsumoController {

    @Autowired
    private InsumoService servicio;


    @GetMapping("/insumo/listar")
    public String MostrarListarColor(Model modelo) {
        modelo.addAttribute("listainsumo", servicio.findAllCustom());
        return "insumo/listar_insumo";
    }

    @GetMapping("/insumo/registro")
    public String MostrarRegistrarColor(Model modelo) {
        return "insumo/registrar_insumo";
    }

    @GetMapping("/insumo/actualizar/{id}")
    public String MostrarActualizarColor(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("color", servicio.findById(id));
        return "insumo/actualizar_insumo";
    }

    @GetMapping("/insumo/habilitar")
    public String MostrarHabilitarInsumo(Model modelo) {
        modelo.addAttribute("listainsumo", servicio.findAll());
        return "insumo/habilitar_insumo";
    }

    @GetMapping("/insumo/eliminar/{id}")
    public String EliminarInsumo(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/insumo/listar";
    }

    @GetMapping("/insumo/habilitar/{id}")
    public String HabilitarInsumo(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/insumo/habilitar";
    }
    
    @GetMapping("/insumo/deshabilitar/{id}")
	public String DeshabilitarInsumo( @PathVariable Long id) {
		servicio.delete(id);
		return "redirect:/insumo/deshabilitar";
	}


    @ModelAttribute("insumo")
    public InsumoEntity ModeloInsumo() {
        return new InsumoEntity();
    }

    @PostMapping("/insumo/registrar")
    public String RegistrarInsumo(@ModelAttribute("insumo") InsumoEntity obj) {
        servicio.add(obj);
        return "redirect:/insumo/listar";
    }

    @PostMapping("/insumo/actualizar/{id}")
    public String ActualizarInsumo(@ModelAttribute("insumo") InsumoEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/insumo/listar";
    }
}

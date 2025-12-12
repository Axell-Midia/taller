package pe.com.taller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.taller.entity.MecanicoEntity;
import pe.com.taller.service.MecanicoService;

@Controller
public class MecanicoController {

    @Autowired
    private MecanicoService servicio;

    // LISTAR MECÁNICOS ACTIVOS
    @GetMapping("/mecanico/listar")
    public String mostrarListarMecanico(Model modelo) {
        modelo.addAttribute("listamecanico", servicio.findAllCustom());
        return "mecanico/listar_mecanico";
    }

    // MOSTRAR FORMULARIO DE REGISTRO
    @GetMapping("/mecanico/registro")
    public String mostrarRegistrarMecanico(Model modelo) {
        return "mecanico/registrar_mecanico";
    }

    // MOSTRAR FORMULARIO DE ACTUALIZACIÓN
    @GetMapping("/mecanico/actualizar/{id}")
    public String mostrarActualizarMecanico(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("mecanico", servicio.findById(id));
        return "mecanico/actualizar_mecanico";
    }

    // HABILITAR MECÁNICOS (LISTA COMPLETA)
    @GetMapping("/mecanico/habilitar")
    public String mostrarHabilitarMecanico(Model modelo) {
        modelo.addAttribute("listamecanico", servicio.findAll());
        return "mecanico/habilitar_mecanico";
    }

    // ELIMINAR (DESHABILITAR) MECÁNICO
    @GetMapping("/mecanico/eliminar/{id}")
    public String eliminarMecanico(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/mecanico/listar";
    }

    // HABILITAR MECÁNICO
    @GetMapping("/mecanico/habilitar/{id}")
    public String habilitarMecanico(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/mecanico/habilitar";
    }

    // OBJETO PARA FORMULARIOS
    @ModelAttribute("mecanico")
    public MecanicoEntity modeloMecanico() {
        return new MecanicoEntity();
    }

    // REGISTRAR MECÁNICO
    @PostMapping("/mecanico/registrar")
    public String registrarMecanico(@ModelAttribute("mecanico") MecanicoEntity obj) {
        servicio.add(obj);
        return "redirect:/mecanico/listar";
    }

    // ACTUALIZAR MECÁNICO
    @PostMapping("/mecanico/actualizar/{id}")
    public String actualizarMecanico(@ModelAttribute("mecanico") MecanicoEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/mecanico/listar";
    }
}

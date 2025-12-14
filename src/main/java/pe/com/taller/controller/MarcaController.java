package pe.com.taller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pe.com.taller.entity.MarcaEntity;
import pe.com.taller.service.MarcaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MarcaController {

    @Autowired
    private MarcaService servicio;

    // Ruta para listar marcas
    @GetMapping("/marca/listar")
    public String MostrarListarMarca(Model modelo) {
        modelo.addAttribute("listamarca", servicio.findAllCustom());
        return "marca/listar_marca";
    }

    // Ruta para registrar marca
    @GetMapping("/marca/registro")
    public String MostrarRegistrarMarca(Model modelo) {
        return "marca/registrar_marca";
    }

    // Ruta para actualizar marca
    @GetMapping("/marca/actualizar/{id}")
    public String MostrarActualizarMarca(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listamarca", servicio.findById(id));
        return "marca/actualizar_marca";
    }

    // Ruta para mostrar marcas habilitadas/deshabilitadas
    @GetMapping("/marca/habilitar")
    public String MostrarHabilitarMarca(Model modelo) {
        modelo.addAttribute("listamarca", servicio.findAll());
        return "marca/habilitar_marca";
    }

    // Acción para eliminar marca (deshabilitar)
    @GetMapping("/marca/eliminar/{id}")
    public String EliminarMarca(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/marca/listar";
    }

    // Acción para habilitar marca
    @GetMapping("/marca/habilitar/{id}")
    public String HabilitarMarca(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/marca/habilitar";
    }

    // Acción para deshabilitar marca
    @GetMapping("/marca/deshabilitar/{id}")
    public String DeshabilitarMarca(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/marca/deshabilitar";
    }

    // Modelo compartido para el formulario
    @ModelAttribute("marca")
    public MarcaEntity ModeloMarca() {
        return new MarcaEntity();
    }

    // Acción POST para registrar marca
    @PostMapping("/marca/registrar")
    public String RegistrarMarca(@ModelAttribute("marca") MarcaEntity obj) {
        servicio.add(obj);
        return "redirect:/marca/listar";
    }

    // Acción POST para actualizar marca
    @PostMapping("/marca/actualizar/{id}")
    public String ActualizarMarca(@ModelAttribute("marca") MarcaEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/marca/listar";
    }
}

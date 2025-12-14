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

    @GetMapping("/marca/listar")
    public String listarMarca(Model modelo) {
        modelo.addAttribute("listamarca", servicio.findByEstadoTrue());
        return "marca/listar_marca";
    }

    // Listar marcas de VEHICULOS
    @GetMapping("/marca/listar/vehiculo")
    public String listarMarcaVehiculo(Model modelo) {
        modelo.addAttribute("listamarca",
                servicio.findByTipoAndEstadoTrue("VEHICULO"));
        return "marca/listar_marca";
    }

    // Listar marcas de INSUMOS
    @GetMapping("/marca/listar/insumo")
    public String listarMarcaInsumo(Model modelo) {
        modelo.addAttribute("listamarca",
                servicio.findByTipoAndEstadoTrue("INSUMO"));
        return "marca/listar_marca";
    }


    @GetMapping("/marca/registro")
    public String mostrarRegistrarMarca() {
        return "marca/registrar_marca";
    }

    @PostMapping("/marca/registrar")
    public String registrarMarca(@ModelAttribute("marca") MarcaEntity obj) {
        servicio.add(obj);
        return "redirect:/marca/listar";
    }


    @GetMapping("/marca/actualizar/{id}")
    public String mostrarActualizarMarca(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("marca", servicio.findById(id));
        return "marca/actualizar_marca";
    }

    @PostMapping("/marca/actualizar/{id}")
    public String actualizarMarca(@ModelAttribute("marca") MarcaEntity obj,
                                  @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/marca/listar";
    }


    @GetMapping("/marca/habilitar")
    public String mostrarHabilitarMarca(Model modelo) {
        modelo.addAttribute("listamarca", servicio.findAll());
        return "marca/habilitar_marca";
    }

    @GetMapping("/marca/eliminar/{id}")
    public String eliminarMarca(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/marca/listar";
    }

    @GetMapping("/marca/habilitar/{id}")
    public String habilitarMarca(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/marca/habilitar";
    }

    @GetMapping("/marca/deshabilitar/{id}")
    public String deshabilitarMarca(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/marca/habilitar";
    }


    @ModelAttribute("marca")
    public MarcaEntity modeloMarca() {
        return new MarcaEntity();
    }
}

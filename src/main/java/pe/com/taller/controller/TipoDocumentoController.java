package pe.com.taller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.com.taller.entity.TipoDocumentoEntity;
import pe.com.taller.service.TipoDocumentoService;

@Controller
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService servicio;

    @GetMapping("/tipodocumento/listar")
    public String mostrarListarTipoDocumento(Model modelo) {
        modelo.addAttribute("listatipodocumento", servicio.findAllCustom());
        return "tipodocumento/listar_tipodocumento";
    }

    @GetMapping("/tipodocumento/registro")
    public String mostrarRegistrarTipoDocumento(Model modelo) {
        return "tipodocumento/registrar_tipodocumento";
    }

    @GetMapping("/tipodocumento/actualizar/{id}")
    public String mostrarActualizarTipoDocumento(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listatipodocumento", servicio.findById(id));
        return "tipodocumento/actualizar_tipodocumento";
    }

    @GetMapping("/tipodocumento/habilitar")
    public String mostrarHabilitarTipoDocumento(Model modelo) {
        modelo.addAttribute("listatipodocumento", servicio.findAll());
        return "tipodocumento/habilitar_tipodocumento";
    }

    @GetMapping("/tipodocumento/eliminar/{id}")
    public String eliminarTipoDocumento(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/tipodocumento/listar";
    }

    @GetMapping("/tipodocumento/habilitar/{id}")
    public String habilitarTipoDocumento(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/tipodocumento/habilitar";
    }

    @GetMapping("/tipodocumento/deshabilitar/{id}")
    public String deshabilitarTipoDocumento(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/tipodocumento/deshabilitar";
    }

    @ModelAttribute("tipodocumento")
    public TipoDocumentoEntity modeloTipoDocumento() {
        return new TipoDocumentoEntity();
    }

    @PostMapping("/tipodocumento/registrar")
    public String registrarTipoDocumento(@ModelAttribute("tipodocumento") TipoDocumentoEntity obj) {
        servicio.add(obj);
        return "redirect:/tipodocumento/listar";
    }

    @PostMapping("/tipodocumento/actualizar/{id}")
    public String actualizarTipoDocumento(@ModelAttribute("tipodocumento") TipoDocumentoEntity obj,
                                          @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/tipodocumento/listar";
    }
}

package pe.com.taller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.com.taller.entity.ClienteEntity;
import pe.com.taller.entity.TipoDocumentoEntity;
import pe.com.taller.service.ClienteService;
import pe.com.taller.service.TipoDocumentoService;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService servicio;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping("/cliente/listar")
    public String MostrarListarCliente(Model model) {
        model.addAttribute("listacliente", servicio.findAllCustom());
        return "cliente/listar_cliente";
    }

    @GetMapping("/cliente/registro")
    public String MostrarRegistrarCliente(Model model) {
        model.addAttribute("cliente", new ClienteEntity());

        List<TipoDocumentoEntity> tipos = tipoDocumentoService.findAll();
        model.addAttribute("listatipodoc", tipos);

        return "cliente/registrar_cliente";
    }

    @ModelAttribute("cliente")
    public ClienteEntity ModeloCliente() {
        return new ClienteEntity();
    }

    @PostMapping("/cliente/registrar")
    public String registrarCliente(@ModelAttribute("cliente") ClienteEntity obj) {
        servicio.add(obj);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/cliente/actualizar/{id}")
    public String actualizarCliente(@PathVariable("id") Long id, Model model) {
        ClienteEntity cliente = servicio.findById(id);
        model.addAttribute("cliente", cliente);

        List<TipoDocumentoEntity> tipos = tipoDocumentoService.findAll();
        model.addAttribute("listatipodoc", tipos);

        return "cliente/actualizar_cliente";
    }

    @PostMapping("/cliente/actualizar/{id}")
    public String actualizarCliente(@ModelAttribute("cliente") ClienteEntity cliente, @PathVariable Long id) {
        servicio.update(cliente, id);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/cliente/habilitar")
    public String MostrarHabilitarCliente(Model modelo) {
        modelo.addAttribute("listacliente", servicio.findAll());
        return "cliente/habilitar_cliente";
    }

    @GetMapping("/cliente/habilitar/{id}")
    public String habilitarCliente(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/cliente/habilitar";
    }

    @GetMapping("/cliente/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/cliente/listar";
    }
}

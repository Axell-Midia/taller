package pe.com.taller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.taller.entity.ProveedorEntity;
import pe.com.taller.service.ProveedorService;

@Controller
public class ProveedorController {

    @Autowired
    private ProveedorService servicio;

    // LISTAR PROVEEDORES ACTIVOS
    @GetMapping("/proveedor/listar")
    public String MostrarListarProveedor(Model modelo) {
        modelo.addAttribute("listaproveedor", servicio.findAllCustom());
        return "proveedor/listar_proveedor";
    }

    // MOSTRAR FORMULARIO DE REGISTRO
    @GetMapping("/proveedor/registro")
    public String MostrarRegistrarProveedor(Model modelo) {
        return "proveedor/registrar_proveedor";
    }

    // MOSTRAR FORMULARIO DE ACTUALIZACIÓN
    @GetMapping("/proveedor/actualizar/{id}")
    public String MostrarActualizarProveedor(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("proveedor", servicio.findById(id));
        return "proveedor/actualizar_proveedor";
    }

    // HABILITAR PROVEEDORES (LISTA COMPLETA)
    @GetMapping("/proveedor/habilitar")
    public String MostrarHabilitarProveedor(Model modelo) {
        modelo.addAttribute("listaproveedor", servicio.findAll());
        return "proveedor/habilitar_proveedor";
    }

    // ELIMINAR (DESHABILITAR) PROVEEDOR
    @GetMapping("/proveedor/eliminar/{id}")
    public String EliminarProveedor(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/proveedor/listar";
    }

    // HABILITAR PROVEEDOR
    @GetMapping("/proveedor/habilitar/{id}")
    public String HabilitarProveedor(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/proveedor/habilitar";
    }

    // DESHABILITAR DESDE LA VISTA DE DESHABILITAR
    @GetMapping("/proveedor/deshabilitar/{id}")
    public String DeshabilitarProveedor(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/proveedor/deshabilitar";
    }

    // INICIALIZAR OBJETO PARA FORMULARIOS
    @ModelAttribute("proveedor")
    public ProveedorEntity ModeloProveedor() {
        return new ProveedorEntity();
    }

    // REGISTRAR PROVEEDOR
    @PostMapping("/proveedor/registrar")
    public String RegistrarProveedor(@ModelAttribute("proveedor") ProveedorEntity obj) {
        servicio.add(obj);
        return "redirect:/proveedor/listar";
    }

    // ACTUALIZAR PROVEEDOR
    @PostMapping("/proveedor/actualizar/{id}")
    public String ActualizarProveedor(@ModelAttribute("proveedor") ProveedorEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/proveedor/listar";
    }
}

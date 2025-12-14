package pe.com.taller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.com.taller.entity.ClienteEntity;
import pe.com.taller.entity.MarcaEntity;
import pe.com.taller.entity.VehiculoEntity;
import pe.com.taller.service.ClienteService;
import pe.com.taller.service.MarcaService;
import pe.com.taller.service.VehiculoService;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("listavehiculo", vehiculoService.findAllCustom());
        return "vehiculo/listar_vehiculo";
    }

    @GetMapping("/registro")
    public String registro(Model model) {
        model.addAttribute("vehiculo", new VehiculoEntity());
        model.addAttribute("listacliente", clienteService.findAllCustom());
        model.addAttribute(
                "listamarca",
                marcaService.findByTipoAndEstadoTrue("VEHICULO")
            );        return "vehiculo/registrar_vehiculo";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute VehiculoEntity vehiculo) {
        vehiculoService.add(vehiculo);
        return "redirect:/vehiculo/listar";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, Model model) {
        VehiculoEntity vehiculo = vehiculoService.findById(id);
        List<ClienteEntity> clientes = clienteService.findAllCustom(); 
        List<MarcaEntity> marcas = marcaService.findByTipoAndEstadoTrue("VEHICULO"); 

        model.addAttribute("vehiculo", vehiculo);
        model.addAttribute("listaCliente", clientes);
        model.addAttribute("listamarca", marcas); 

        return "vehiculo/actualizar_vehiculo";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarPost(@ModelAttribute VehiculoEntity vehiculo, @PathVariable Long id) {
        vehiculoService.update(vehiculo, id);
        return "redirect:/vehiculo/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        vehiculoService.delete(id);
        return "redirect:/vehiculo/listar";
    }

    @GetMapping("/habilitar")
    public String habilitar(Model model) {
        model.addAttribute("listavehiculo", vehiculoService.findAll());
        return "vehiculo/habilitar_vehiculo";
    }

    @GetMapping("/habilitar/{id}")
    public String habilitarVehiculo(@PathVariable Long id) {
        vehiculoService.enable(id);
        return "redirect:/vehiculo/habilitar";
    }
}

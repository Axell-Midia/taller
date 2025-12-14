package pe.com.taller.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.com.taller.entity.MarcaEntity;
import pe.com.taller.service.MarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaRestController {

    @Autowired
    private MarcaService servicio;

    @GetMapping
    public List<MarcaEntity> findAll() {
        return servicio.findAll();
    }
    @GetMapping("/activas")
    public List<MarcaEntity> findActivas() {
        return servicio.findByEstadoTrue();
    }

    @GetMapping("/tipo/{tipo}")
    public List<MarcaEntity> findByTipo(@PathVariable String tipo) {
        return servicio.findByTipoAndEstadoTrue(tipo);
    }

    @GetMapping("/custom")
    public List<MarcaEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public MarcaEntity findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public MarcaEntity add(@RequestBody MarcaEntity obj) {
        return servicio.add(obj);
    }

    @PutMapping("/{id}")
    public MarcaEntity update(@RequestBody MarcaEntity obj, @PathVariable Long id) {
        return servicio.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public MarcaEntity delete(@PathVariable Long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public MarcaEntity enable(@PathVariable Long id) {
        return servicio.enable(id);
    }
}

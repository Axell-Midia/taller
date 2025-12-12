package pe.com.taller.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.taller.entity.MecanicoEntity;
import pe.com.taller.service.MecanicoService;

@RestController
@RequestMapping("/mecanico")
public class MecanicoRestController {

    @Autowired
    private MecanicoService servicio;

    @GetMapping
    public List<MecanicoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<MecanicoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public MecanicoEntity findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public MecanicoEntity add(@RequestBody MecanicoEntity obj) {
        return servicio.add(obj);
    }

    @PutMapping("/{id}")
    public MecanicoEntity update(@RequestBody MecanicoEntity obj, @PathVariable Long id) {
        return servicio.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public MecanicoEntity delete(@PathVariable Long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public MecanicoEntity enable(@PathVariable Long id) {
        return servicio.enable(id);
    }
}

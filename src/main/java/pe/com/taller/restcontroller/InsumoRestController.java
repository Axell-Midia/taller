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

import pe.com.taller.entity.InsumoEntity;
import pe.com.taller.service.InsumoService;


@RestController
@RequestMapping("/insumo") 
public class InsumoRestController {

	@Autowired 
	private InsumoService servicio;
	
	@GetMapping 
	public List<InsumoEntity> findAll() {
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<InsumoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	InsumoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping 
	public InsumoEntity add(@RequestBody InsumoEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public InsumoEntity update(@RequestBody InsumoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public InsumoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
	
	@PutMapping("/enable/{id}")
	public InsumoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
	
}

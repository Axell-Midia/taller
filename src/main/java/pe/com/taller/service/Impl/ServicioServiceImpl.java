package pe.com.taller.service.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.taller.entity.ServicioEntity;
import pe.com.taller.repository.ServicioRepository;
import pe.com.taller.service.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService {
	@Autowired 
	private ServicioRepository repository;
	
	@Override
	public List<ServicioEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public List<ServicioEntity> findAllCustom() {
		return repository.findAllCustom();
	}

	@Override
	public ServicioEntity findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public ServicioEntity add(ServicioEntity obj) {
		return repository.save(obj);
	}

	@Override
	public ServicioEntity update(ServicioEntity obj, Long id) {
		ServicioEntity objcol = repository.findById(id).get();
		BeanUtils.copyProperties(obj, objcol);
		return repository.save(objcol);
	}

	@Override
	public ServicioEntity delete(Long id) {
		ServicioEntity objcol = repository.findById(id).get();
		objcol.setEstado(false);
		return repository.save(objcol);
	}

	@Override
	public ServicioEntity enable(Long id) {
		ServicioEntity objcol = repository.findById(id).get();
		objcol.setEstado(true);
		return repository.save(objcol);
	}

}

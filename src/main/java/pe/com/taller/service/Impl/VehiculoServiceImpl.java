package pe.com.taller.service.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.taller.entity.VehiculoEntity;
import pe.com.taller.repository.VehiculoRepository;
import pe.com.taller.service.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService {
	
	@Autowired 
	private VehiculoRepository repository;
	
	@Override
	public List<VehiculoEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public List<VehiculoEntity> findAllCustom() {
		return repository.findAllCustom();
	}

	@Override
	public VehiculoEntity findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public VehiculoEntity add(VehiculoEntity obj) {
		return repository.save(obj);
	}

	@Override
	public VehiculoEntity update(VehiculoEntity obj, Long id) {
		VehiculoEntity objsex = repository.findById(id).get();
		BeanUtils.copyProperties(obj, objsex);
		return repository.save(objsex);
	}

	@Override
	public VehiculoEntity delete(Long id) {
		VehiculoEntity objsex = repository.findById(id).get();
		objsex.setEstado(false);
		return repository.save(objsex);
	}

	@Override
	public VehiculoEntity enable(Long id) {
		VehiculoEntity objsex = repository.findById(id).get();
		objsex.setEstado(true);
		return repository.save(objsex);
	}

}
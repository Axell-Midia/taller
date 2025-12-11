package pe.com.taller.service.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.taller.entity.InsumoEntity;
import pe.com.taller.repository.InsumoRepository;
import pe.com.taller.service.InsumoService;


@Service
public class InsumosServiceImpl implements InsumoService {
	
	@Autowired 
	private InsumoRepository repository;
	
	@Override
	public List<InsumoEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public List<InsumoEntity> findAllCustom() {
		return repository.findAllCustom();
	}

	@Override
	public InsumoEntity findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public InsumoEntity add(InsumoEntity obj) {
		return repository.save(obj);
	}

	@Override
	public InsumoEntity update(InsumoEntity obj, Long id) {
		InsumoEntity objcol = repository.findById(id).get();
		BeanUtils.copyProperties(obj, objcol);
		return repository.save(objcol);
	}

	@Override
	public InsumoEntity delete(Long id) {
		InsumoEntity objcol = repository.findById(id).get();
		objcol.setEstado(false);
		return repository.save(objcol);
	}

	@Override
	public InsumoEntity enable(Long id) {
		InsumoEntity objcol = repository.findById(id).get();
		objcol.setEstado(true);
		return repository.save(objcol);
	}

}

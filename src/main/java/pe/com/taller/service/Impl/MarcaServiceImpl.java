package pe.com.taller.service.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.taller.entity.MarcaEntity;
import pe.com.taller.repository.MarcaRepository;
import pe.com.taller.service.MarcaService;


@Service
public class MarcaServiceImpl implements MarcaService {
	
	@Autowired 
	private MarcaRepository repository;
	
	@Override
	public List<MarcaEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public List<MarcaEntity> findAllCustom() {
		return repository.findAllCustom();
	}

	@Override
	public MarcaEntity findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public MarcaEntity add(MarcaEntity obj) {
		return repository.save(obj);
	}

	@Override
	public MarcaEntity update(MarcaEntity obj, Long id) {
		MarcaEntity objmar = repository.findById(id).get();
		BeanUtils.copyProperties(obj, objmar);
		return repository.save(objmar);
	}

	@Override
	public MarcaEntity delete(Long id) {
		MarcaEntity objmar = repository.findById(id).get();
		objmar.setEstado(false);
		return repository.save(objmar);
	}

	@Override
	public MarcaEntity enable(Long id) {
		MarcaEntity objmar = repository.findById(id).get();
		objmar.setEstado(true);
		return repository.save(objmar);
	}

}

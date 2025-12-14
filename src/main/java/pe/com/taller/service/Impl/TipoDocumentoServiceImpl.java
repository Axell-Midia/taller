package pe.com.taller.service.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.taller.entity.TipoDocumentoEntity;
import pe.com.taller.repository.TipoDocumentoRepository;
import pe.com.taller.service.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
		
	@Autowired 
	private TipoDocumentoRepository repositorio;
	
	@Override
	public List<TipoDocumentoEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<TipoDocumentoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public TipoDocumentoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public TipoDocumentoEntity add(TipoDocumentoEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public TipoDocumentoEntity update(TipoDocumentoEntity obj, Long id) {
		TipoDocumentoEntity objtd = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objtd);
		return repositorio.save(objtd);
	}

	@Override
	public TipoDocumentoEntity delete(Long id) {
		TipoDocumentoEntity objtd = repositorio.findById(id).get();
		objtd.setEstado(false);
		return repositorio.save(objtd);
		
	}

	@Override
	public TipoDocumentoEntity enable(Long id) {
		TipoDocumentoEntity objtd = repositorio.findById(id).get();
		objtd.setEstado(true);
		return repositorio.save(objtd);
	}

}

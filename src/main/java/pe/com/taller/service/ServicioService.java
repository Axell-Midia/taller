package pe.com.taller.service;

import java.util.List;

import pe.com.taller.entity.ServicioEntity;

public interface ServicioService {
	List<ServicioEntity> findAll();
	List<ServicioEntity> findAllCustom();
	ServicioEntity findById(Long id);
	ServicioEntity add(ServicioEntity obj);
	ServicioEntity update(ServicioEntity obj, Long id);
	ServicioEntity delete(Long id);
	ServicioEntity enable(Long id);
}

package pe.com.taller.service;

import java.util.List;

import pe.com.taller.entity.VehiculoEntity;

public interface VehiculoService {
	List<VehiculoEntity> findAll();
	List<VehiculoEntity> findAllCustom();
	VehiculoEntity findById(Long id);
	VehiculoEntity add(VehiculoEntity obj);
	VehiculoEntity update(VehiculoEntity obj, Long id);
	VehiculoEntity delete(Long id);
	VehiculoEntity enable(Long id);
}

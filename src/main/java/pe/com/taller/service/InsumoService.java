package pe.com.taller.service;

import java.util.List;

import pe.com.taller.entity.InsumoEntity;



public interface InsumoService {
	List<InsumoEntity> findAll();
	List<InsumoEntity> findAllCustom();
	InsumoEntity findById(Long id);
	InsumoEntity add(InsumoEntity obj);
	InsumoEntity update(InsumoEntity obj, Long id);
	InsumoEntity delete(Long id);
	InsumoEntity enable(Long id);
}

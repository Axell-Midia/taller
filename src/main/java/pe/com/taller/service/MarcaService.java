package pe.com.taller.service;

import java.util.List;
import pe.com.taller.entity.MarcaEntity;

public interface MarcaService {

    List<MarcaEntity> findAll();               
    List<MarcaEntity> findByEstadoTrue();       
    List<MarcaEntity> findAllCustom(); 
    List<MarcaEntity> findByTipoAndEstadoTrue(String tipo); // VEHICULO / INSUMO
    MarcaEntity findById(Long id);
    MarcaEntity add(MarcaEntity obj);
    MarcaEntity update(MarcaEntity obj, Long id);
    MarcaEntity delete(Long id);   
    MarcaEntity enable(Long id);  
}

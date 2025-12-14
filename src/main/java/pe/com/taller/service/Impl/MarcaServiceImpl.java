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
    public List<MarcaEntity> findByEstadoTrue() {
        return repository.findByEstadoTrue(); 
    }

    @Override
    public List<MarcaEntity> findAllCustom() {
        return repository.findAllCustom();
    }
    
    @Override
    public List<MarcaEntity> findByTipoAndEstadoTrue(String tipo) {
        return repository.findByTipoAndEstadoTrue(tipo); 
    }

    @Override
    public MarcaEntity findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public MarcaEntity add(MarcaEntity obj) {
        obj.setEstado(true);  
        return repository.save(obj);
    }
    @Override
    public MarcaEntity update(MarcaEntity obj, Long id) {
        MarcaEntity objmar = repository.findById(id).orElse(null);
        if (objmar != null) {
            BeanUtils.copyProperties(obj, objmar, "codigo"); 
            return repository.save(objmar);
        }
        return null;
    }

    @Override
    public MarcaEntity delete(Long id) {
        MarcaEntity objmar = repository.findById(id).orElse(null);
        if (objmar != null) {
            objmar.setEstado(false); 
            return repository.save(objmar);
        }
        return null;
    }

    @Override
    public MarcaEntity enable(Long id) {
        MarcaEntity objmar = repository.findById(id).orElse(null);
        if (objmar != null) {
            objmar.setEstado(true); 
            return repository.save(objmar);
        }
        return null;
    }
}

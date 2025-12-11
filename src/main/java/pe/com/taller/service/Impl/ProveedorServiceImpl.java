package pe.com.taller.service.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.taller.entity.ProveedorEntity;
import pe.com.taller.repository.ProveedorRepository;
import pe.com.taller.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository repository;

    @Override
    public List<ProveedorEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProveedorEntity> findAllCustom() {
        return repository.findAllCustom();
    }

    @Override
    public ProveedorEntity findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public ProveedorEntity add(ProveedorEntity obj) {
        return repository.save(obj);
    }

    @Override
    public ProveedorEntity update(ProveedorEntity obj, Long id) {
        ProveedorEntity objpro = repository.findById(id).get();
        BeanUtils.copyProperties(obj, objpro);
        return repository.save(objpro);
    }

    @Override
    public ProveedorEntity delete(Long id) {
        ProveedorEntity objpro = repository.findById(id).get();
        objpro.setEstado(false);
        return repository.save(objpro);
    }

    @Override
    public ProveedorEntity enable(Long id) {
        ProveedorEntity objpro = repository.findById(id).get();
        objpro.setEstado(true);
        return repository.save(objpro);
    }
}

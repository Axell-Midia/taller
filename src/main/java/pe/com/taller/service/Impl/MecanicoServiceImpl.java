package pe.com.taller.service.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.taller.entity.MecanicoEntity;
import pe.com.taller.repository.MecanicoRepository;
import pe.com.taller.service.MecanicoService;

@Service
public class MecanicoServiceImpl implements MecanicoService {

    @Autowired
    private MecanicoRepository repository;

    @Override
    public List<MecanicoEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<MecanicoEntity> findAllCustom() {
        return repository.findAllCustom();
    }

    @Override
    public MecanicoEntity findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public MecanicoEntity add(MecanicoEntity obj) {
        return repository.save(obj);
    }

    @Override
    public MecanicoEntity update(MecanicoEntity obj, Long id) {
        MecanicoEntity objmec = repository.findById(id).get();
        BeanUtils.copyProperties(obj, objmec);
        return repository.save(objmec);
    }

    @Override
    public MecanicoEntity delete(Long id) {
        MecanicoEntity objmec = repository.findById(id).get();
        objmec.setEstado(false);
        return repository.save(objmec);
    }

    @Override
    public MecanicoEntity enable(Long id) {
        MecanicoEntity objmec = repository.findById(id).get();
        objmec.setEstado(true);
        return repository.save(objmec);
    }
}

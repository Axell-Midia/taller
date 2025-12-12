package pe.com.taller.service;

import java.util.List;
import pe.com.taller.entity.MecanicoEntity;

public interface MecanicoService {

    List<MecanicoEntity> findAll();

    List<MecanicoEntity> findAllCustom();

    MecanicoEntity findById(Long id);

    MecanicoEntity add(MecanicoEntity obj);

    MecanicoEntity update(MecanicoEntity obj, Long id);

    MecanicoEntity delete(Long id);

    MecanicoEntity enable(Long id);
}

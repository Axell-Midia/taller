package pe.com.taller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.taller.entity.MecanicoEntity;

import java.util.List;

public interface MecanicoRepository extends JpaRepository<MecanicoEntity, Long> {

    @Query("SELECT m FROM MecanicoEntity m WHERE m.estado = true")
    List<MecanicoEntity> findAllCustom();
}

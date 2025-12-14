package pe.com.taller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.taller.entity.VehiculoEntity;

public interface VehiculoRepository extends JpaRepository<VehiculoEntity,Long> {

    @Query("SELECT s FROM VehiculoEntity s WHERE s.estado = true")
    List<VehiculoEntity> findAllCustom();
}
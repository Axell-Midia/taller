package pe.com.taller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.taller.entity.ProveedorEntity;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {

    @Query("SELECT p FROM ProveedorEntity p WHERE p.estado = true")
    List<ProveedorEntity> findAllCustom();
}

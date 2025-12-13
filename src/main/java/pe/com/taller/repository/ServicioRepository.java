package pe.com.taller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.taller.entity.ServicioEntity;

public interface ServicioRepository extends JpaRepository<ServicioEntity, Long> { 
	@Query("SELECT s FROM ServicioEntity s WHERE s.estado = true")
	List<ServicioEntity> findAllCustom();

}

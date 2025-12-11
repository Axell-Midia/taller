package pe.com.taller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.taller.entity.InsumoEntity;

import java.util.List;

public interface InsumoRepository extends JpaRepository<InsumoEntity, Long> {  // Usamos Long como el tipo de clave primaria
	@Query("SELECT i FROM InsumoEntity i WHERE i.estado = true")
	List<InsumoEntity> findAllCustom();

}

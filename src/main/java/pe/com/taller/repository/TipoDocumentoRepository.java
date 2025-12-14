package pe.com.taller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.taller.entity.TipoDocumentoEntity;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Long> {

	@Query("SELECT td FROM TipoDocumentoEntity td WHERE td.estado = true")
	List<TipoDocumentoEntity> findAllCustom();

}


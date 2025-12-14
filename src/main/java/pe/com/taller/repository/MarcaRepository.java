package pe.com.taller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.taller.entity.MarcaEntity;


public interface MarcaRepository extends JpaRepository<MarcaEntity, Long> //
{
	@Query("SELECT s FROM MarcaEntity s WHERE s.estado= true")
	List<MarcaEntity> findAllCustom();

}

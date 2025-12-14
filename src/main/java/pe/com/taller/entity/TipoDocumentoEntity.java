package pe.com.taller.entity;



import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor 
@Data 
@Builder
@Entity(name = "TipoDocumentoEntity") 
@Table(name= "tipodocumento")

public class TipoDocumentoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codtipd") //indica el nombre de la columna en la base de datos
	@GeneratedValue(strategy = GenerationType.IDENTITY) //indica que el valor se genera automaticamente
	private long codigo;
	
	@Column(name = "nomtipd",length = 30, nullable = false) //indica el nombre de la columna en la base de datos
	private String nombre;
	@Column(name="esttipd")
	private boolean estado;
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	   public Long getId() {
	        return codigo;
	   }

	    public void setId(Long codigo) {
	        this.codigo = codigo;
	    }

	    public String getDescripcion() {
	        return nombre;
	    }


	    public void setDescripcion(String nombre) {
	        this.nombre = nombre;
	    }
	}
	
	
	

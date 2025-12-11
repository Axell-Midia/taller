package pe.com.taller.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity(name = "ProveedorEntity")
@Table(name = "proveedor")
public class ProveedorEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codpro")
    private Long codigo;  

    @Column(name = "nompro", length = 100, nullable = false)
    private String nombre;

    @Column(name = "dirpro", length = 150)
    private String direccion;

    @Column(name = "telpro", length = 20)
    private String telefono;

    @Column(name = "corpro", length = 100)
    private String correo;

    @Column(name = "estpro", length = 20)
    private String estado;  
}

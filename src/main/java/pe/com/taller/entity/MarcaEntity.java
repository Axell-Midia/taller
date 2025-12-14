package pe.com.taller.entity;

import java.io.Serializable;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "marca")
public class MarcaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codmar")
    private Long codigo;

    @Column(name = "nommar", length = 100, nullable = false)
    private String nombre;

    @Column(name = "tipo", nullable = false)
    private String tipo; // VEHICULO o INSUMO

    @Column(name = "estmar", nullable = false)
    private boolean estado;
}

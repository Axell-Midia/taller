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
@Entity(name = "MecanicoEntity")
@Table(name = "mecanico")
public class MecanicoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codmec")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nommec", length = 100, nullable = false)
    private String nombre;

    @Column(name = "telmec", length = 20)
    private String telefono;

    @Column(name = "estmec", length = 20, nullable = false)
    private boolean estado;
}

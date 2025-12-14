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
@Entity(name = "VehiculoEntity")
@Table(name = "vehiculo")
public class VehiculoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codveh")
    private Long codigo;

    @Column(name = "plaveh", nullable = false, unique = true, length = 20)
    private String placa;

    @Column(name = "modveh", nullable = false, length = 50)
    private String modelo;

    @Column(name = "aniveh", nullable = false)
    private Integer anio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codmar", nullable = false)
    private MarcaEntity marca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codcli", nullable = false)
    private ClienteEntity cliente;

    @Column(name = "estveh", nullable = false)
    private boolean estado;
}

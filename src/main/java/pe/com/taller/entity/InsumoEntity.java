package pe.com.taller.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "InsumoEntity")
@Table(name = "insumo")
public class InsumoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codins")
    private Long codigo;

    @Column(name = "nomins", length = 100, nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "codmar", nullable = false)
    private MarcaEntity marca;

    @Column(name = "cosins", precision = 10, scale = 2)
    private BigDecimal costo;

    @ManyToOne
    @JoinColumn(name = "codpro", nullable = false)
    private ProveedorEntity proveedor;

    @Column(name = "estins", nullable = false)
    private boolean estado;
}

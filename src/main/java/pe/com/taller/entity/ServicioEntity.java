package pe.com.taller.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Entity
@Table(name = "servicio")
public class ServicioEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "codser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;  

    @Column(name = "tipser", length = 100)
    private String tipo;

    @Column(name = "cosser")
    private BigDecimal costo;

    @Column(name = "tieser")
    private int tiempo;

    @Column(name = "estser", nullable = false)
    private Boolean estado;

	
}

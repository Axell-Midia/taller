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
@Table(name = "cliente")
public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcli")
    private Long codigo;

    @Column(name = "nomcli", nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "codtipd") 
    private TipoDocumentoEntity tipoDocumento;

    @Column(name = "numdoc", length = 20)
    private String numeroDocumento;

    @Column(name = "dircli", length = 150)
    private String direccion;

    @Column(name = "telcli", length = 20)
    private String telefono;

    @Column(name = "corcli", length = 100)
    private String correo;

    @Column(name = "estcli", nullable = false)
    private boolean estado;
}

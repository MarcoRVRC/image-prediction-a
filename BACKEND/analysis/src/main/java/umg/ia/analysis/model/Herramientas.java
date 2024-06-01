package umg.ia.analysis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "herramientas", schema = "tools_classification")
@Entity
public class Herramientas {
    @Id
    @Column(name = "codigo_producto", nullable = false, unique = true)
    private String codigoProducto;

    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "especificaciones", columnDefinition = "text")
    private String especificaciones;

    @Column(name = "precio", precision = 7, scale = 2)
    private BigDecimal precio;

    @Column(name = "existencias")
    private Integer existencias;

    @Column(name = "img", length = 256)
    private String img;

    @Column(name = "fecha_creacion", nullable = false, insertable = false, updatable = false,
            columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "usuario_creacion", nullable = false, columnDefinition = "varchar(13) DEFAULT '100577075'")
    private String usuarioCreacion;

    @Column(name = "usuario_modificacion", length = 13)
    private String usuarioModificacion;

    private Integer categoria;
}

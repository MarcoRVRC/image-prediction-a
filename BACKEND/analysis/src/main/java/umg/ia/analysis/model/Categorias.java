package umg.ia.analysis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "categorias", schema = "tools_classification")
@Entity
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "categoria", nullable = false)
    private String categoria;

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
}

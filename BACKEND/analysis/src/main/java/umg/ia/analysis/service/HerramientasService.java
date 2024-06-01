package umg.ia.analysis.service;

import org.springframework.data.repository.query.Param;
import umg.ia.analysis.model.Herramientas;

import java.util.List;

public interface HerramientasService {
    Herramientas findByNombreProducto(String nombreProducto);

    List<Herramientas> findPorCategoria(String categoria);
}

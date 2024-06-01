package umg.ia.analysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import umg.ia.analysis.model.Herramientas;

import java.util.List;

@Repository
public interface HerramientasRepository extends JpaRepository<Herramientas, String> {

   Herramientas findByNombreProducto(String nombreProducto);

   @Query(value = "select * from tools_classification.herramientas h \n" +
           "inner join tools_classification.categorias c on c.id_categoria = h.categoria \n" +
           "where c.categoria = :categoria", nativeQuery = true)
   List<Herramientas> findPorCategoria(@Param("categoria") String categoria);
}

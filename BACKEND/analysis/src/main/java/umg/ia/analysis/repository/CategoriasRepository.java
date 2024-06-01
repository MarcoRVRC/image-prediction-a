package umg.ia.analysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umg.ia.analysis.model.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Integer> {
}

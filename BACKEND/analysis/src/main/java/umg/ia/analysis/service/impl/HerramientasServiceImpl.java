package umg.ia.analysis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umg.ia.analysis.model.Herramientas;
import umg.ia.analysis.repository.HerramientasRepository;
import umg.ia.analysis.service.HerramientasService;

import java.util.List;

@Service
public class HerramientasServiceImpl implements HerramientasService {

    @Autowired
    private HerramientasRepository repository;

    @Override
    public Herramientas findByNombreProducto(String nombreProducto) {
        return repository.findByNombreProducto(nombreProducto);
    }

    @Override
    public List<Herramientas> findPorCategoria(String categoria) {
        return repository.findPorCategoria(categoria);
    }


}

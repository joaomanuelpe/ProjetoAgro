package org.agro.projetoagro.services;

import org.agro.projetoagro.entities.Gado;
import org.agro.projetoagro.repositories.GadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GadoService {

    @Autowired
    GadoRepository gadoRepository;

    public Gado add(Gado gado) {
        return gadoRepository.save(gado);
    }

    public Gado get(String gadoNoeme) {
        return gadoRepository.findById(gadoNoeme).orElse(null);
    }

    public List<Gado> getAll() {
        return gadoRepository.findAll();
    }

    public boolean delete(String gadoNoeme) {
        Gado gado = gadoRepository.findById(gadoNoeme).orElse(null);
        try {
           gadoRepository.delete(gado);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

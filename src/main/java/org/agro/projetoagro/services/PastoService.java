package org.agro.projetoagro.services;

import org.agro.projetoagro.entities.Pasto;
import org.agro.projetoagro.repositories.PastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PastoService {
    @Autowired
    private PastoRepository pastoRepository;

    public Pasto add(Pasto pasto) {
        return pastoRepository.save(pasto);
    }

    public Pasto getOneById(int pastoId) {
        return pastoRepository.findById(pastoId).orElse(null);
    }

    public Pasto getOneByNome(String pastoNome) {
        return pastoRepository.findByPastoNome(pastoNome);
    }

    public List<Pasto> getAll() {
        return pastoRepository.findAll();
    }

    public List<Pasto> getAllByInvernada(int invernadaId) {
        return pastoRepository.findByInvernada_InvernadaId(invernadaId);
    }

    public Pasto update(Pasto pasto) {
        return pastoRepository.save(pasto);
    }

    public boolean delete(int pastoId) {
        try {
            pastoRepository.deleteById(pastoId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

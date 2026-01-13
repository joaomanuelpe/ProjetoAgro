package org.agro.projetoagro.services;

import org.agro.projetoagro.entities.Invernada;
import org.agro.projetoagro.repositories.InvernadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class InvernadaService {

    @Autowired
    InvernadaRepository invernadaRepository;

    public Invernada add(Invernada invernada) {
        Invernada novaInvernada = invernadaRepository.save(invernada);
        return novaInvernada;
    }

    public Invernada getOneById(int invernadaId) {
        Invernada invernada = invernadaRepository.findById(invernadaId).orElse(null);
        return invernada;
    }

    public Invernada getOneByNome(String invernadaNome) {
        return invernadaRepository.findInvernadaByNome(invernadaNome);
    }

    public List<Invernada> getAll() {
        return invernadaRepository.findAll();
    }

    public boolean delete(int invernadaId) {
        Invernada invernada = invernadaRepository.findById(invernadaId).orElse(null);
        try {
            invernadaRepository.delete(invernada);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

}

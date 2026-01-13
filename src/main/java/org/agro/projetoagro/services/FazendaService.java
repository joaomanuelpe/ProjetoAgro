package org.agro.projetoagro.services;

import org.agro.projetoagro.entities.Fazenda;
import org.agro.projetoagro.repositories.FazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FazendaService {

    @Autowired
    FazendaRepository fazendaRepository;

    public Fazenda add(Fazenda fazenda) {
        return fazendaRepository.save(fazenda);
    }

    public Fazenda getOneById(int fazendaId) {
        return fazendaRepository.findById(fazendaId).orElse(null);
    }

    public Fazenda getOneByNome(String fazendaNome) {
        return fazendaRepository.findFazendaByNome(fazendaNome);
    }

    public List<Fazenda> getAll() {
        return fazendaRepository.findAll();
    }

    public boolean delete(int fazendaId) {
        Fazenda fazenda = fazendaRepository.findById(fazendaId).orElse(null);
        try {
            fazendaRepository.delete(fazenda);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

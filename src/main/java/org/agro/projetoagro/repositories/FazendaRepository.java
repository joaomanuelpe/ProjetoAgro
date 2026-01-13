package org.agro.projetoagro.repositories;

import org.agro.projetoagro.entities.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FazendaRepository extends JpaRepository<Fazenda, Integer> {
    @Query("SELECT f FROM Fazenda f WHERE f.fazendaNome = :fazendaNome")
    Fazenda findFazendaByNome(@Param("fazendaNome") String fazendaNome);
}

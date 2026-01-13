package org.agro.projetoagro.repositories;

import org.agro.projetoagro.entities.Invernada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvernadaRepository extends JpaRepository<Invernada, Integer> {
    @Query("SELECT i FROM Invernada i WHERE i.invernadaNome = :invernadaNome")
    Invernada findInvernadaByNome(@Param("invernadaNome") String invernadaNome);
}

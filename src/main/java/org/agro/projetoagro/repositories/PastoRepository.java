package org.agro.projetoagro.repositories;

import org.agro.projetoagro.entities.Pasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PastoRepository extends JpaRepository<Pasto, Integer> {
    List<Pasto> findByInvernada_InvernadaId(int invernadaId);
    Pasto findByPastoNome(String pastoNome);
}

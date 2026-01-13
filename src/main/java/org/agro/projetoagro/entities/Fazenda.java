package org.agro.projetoagro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fazenda")
public class Fazenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fazenda_id")
    private int fazendaId;

    @Column(name = "fazenda_nome")
    private String fazendaNome;

    public Fazenda() {
    }

    public Fazenda(int fazendaId, String fazendaNome) {
        this.fazendaId = fazendaId;
        this.fazendaNome = fazendaNome;
    }
}

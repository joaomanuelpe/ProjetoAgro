package org.agro.projetoagro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pasto")
public class Pasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pasto_id")
    private int pastoId;

    @Column(name = "pasto_nome")
    private String pastoNome;

    @ManyToOne
    @JoinColumn(name = "invernada_invernada_id")
    private Invernada invernada;

    @Column(name = "coordenadas", columnDefinition = "json")
    private String coordenadas;

    @Column(name = "pasto_status")
    private String pastoStatus;

    public Pasto() {
    }

    public Pasto(String pastoNome, Invernada invernada, String coordenadas, String pastoStatus) {
        this.pastoNome = pastoNome;
        this.invernada = invernada;
        this.coordenadas = coordenadas;
        this.pastoStatus = pastoStatus;
    }
}

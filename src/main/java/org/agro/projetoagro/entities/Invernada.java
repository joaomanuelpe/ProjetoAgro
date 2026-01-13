package org.agro.projetoagro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "invernada")
@Entity
public class Invernada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invernada_id")
    private int invernadaId;

    @Column(name = "invernada_total")
    private int invernadaTotal;

    @Column(name = "invernada_nome")
    private String invernadaNome;

    @ManyToOne
    @JoinColumn(name = "gado_gado_nome", nullable = true)
    private Gado gado;

    @ManyToOne
    @JoinColumn(name = "fazenda_fazenda_id")
    private Fazenda fazenda;

    public Invernada() {
    }

    public Invernada(int invernadaId, int invernadaTotal, String invernadaNome, Gado gado, Fazenda fazenda) {
        this.invernadaId = invernadaId;
        this.invernadaTotal = invernadaTotal;
        this.invernadaNome = invernadaNome;
        this.gado = gado;
        this.fazenda = fazenda;
    }
}

package org.agro.projetoagro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gado")
public class Gado {
    @Id
    @Column(name = "gado_nome")
    private String gadoNome;

    @Column(name = "gado_qtd")
    private int gadoQtd;

    @Column(name = "gado_tipo")
    private String gadoTipo;

    public Gado() {
    }

    public Gado(String gadoNome, int gadoQtd, String gadoTipo) {
        this.gadoNome = gadoNome;
        this.gadoQtd = gadoQtd;
        this.gadoTipo = gadoTipo;
    }
}

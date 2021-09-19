package br.com.zup.transacoes.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idExterno;

    private String email;

    @OneToMany(mappedBy = "cartao", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Transacao> transacoes;

    public Cartao() {
    }

    public Cartao(String idExterno, String email) {
        this.idExterno = idExterno;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public String getEmail() {
        return email;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}

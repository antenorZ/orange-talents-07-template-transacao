package br.com.zup.transacoes.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idExterno;

    private Double valor;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    public Transacao() {
    }

    public Transacao(String idExterno, Double valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.idExterno = idExterno;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Long getId() {
        return id;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public Double getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}

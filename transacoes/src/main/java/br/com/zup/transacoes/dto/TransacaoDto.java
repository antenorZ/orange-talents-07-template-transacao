package br.com.zup.transacoes.dto;

import br.com.zup.transacoes.model.Cartao;
import br.com.zup.transacoes.model.Estabelecimento;
import br.com.zup.transacoes.model.Transacao;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

public class TransacaoDto {
    private String id;

    private Double valor;

    private Estabelecimento estabelecimento;

    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    public TransacaoDto() {
    }

    public Transacao toModel(){
        return new Transacao(id, valor, estabelecimento, cartao, efetivadaEm);
    }

    public TransacaoDto(String id, Double valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }
}

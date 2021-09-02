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
    private String idExterno;

    private Double valor;

    private Estabelecimento estabelecimento;

    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    public TransacaoDto() {
    }

    public Transacao toModel(){
        return new Transacao(idExterno, valor, estabelecimento, cartao, efetivadaEm);
    }

    public TransacaoDto(String idExterno, Double valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.idExterno = idExterno;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }
}

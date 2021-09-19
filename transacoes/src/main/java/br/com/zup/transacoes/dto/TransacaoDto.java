package br.com.zup.transacoes.dto;

import br.com.zup.transacoes.model.Cartao;
import br.com.zup.transacoes.model.Estabelecimento;
import br.com.zup.transacoes.model.Transacao;
import org.springframework.data.domain.Page;

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

    public TransacaoDto(String id, Double valor, Estabelecimento estabelecimento, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.efetivadaEm = efetivadaEm;
    }

    public static Page<TransacaoDto> toDtoPage(Page<Transacao> page){
        return page.map(transacao -> new TransacaoDto(transacao.getIdExterno(), transacao.getValor(), transacao.getEstabelecimento(), transacao.getEfetivadaEm()));
    }

    public String getId() {
        return id;
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

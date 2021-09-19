package br.com.zup.transacoes.controller;

import br.com.zup.transacoes.dto.TransacaoDto;
import br.com.zup.transacoes.model.Cartao;
import br.com.zup.transacoes.model.Transacao;
import br.com.zup.transacoes.repository.CartaoRepository;
import br.com.zup.transacoes.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
public class TransacoesController {
    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping("/{idCartao}/transacoes")
    public ResponseEntity<?> verTransacoesCartao(@PathVariable String idCartao, Pageable pageable){
        Optional<Cartao> possivelCartao = cartaoRepository.findbyidExterno(idCartao);
        if(!possivelCartao.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Page<Transacao> transacoes = transacaoRepository.findByCartaoidExterno(idCartao, pageable);

        return ResponseEntity.ok(TransacaoDto.toDtoPage(transacoes));
    }
}

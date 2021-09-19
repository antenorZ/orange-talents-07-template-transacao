package br.com.zup.transacoes.repository;

import br.com.zup.transacoes.model.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
    Page<Transacao> findByCartaoidExterno(String idCartao, Pageable pageable);
}

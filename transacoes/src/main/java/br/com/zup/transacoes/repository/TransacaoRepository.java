package br.com.zup.transacoes.repository;

import br.com.zup.transacoes.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
}

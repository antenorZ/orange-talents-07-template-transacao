package br.com.zup.transacoes.repository;

import br.com.zup.transacoes.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    Optional<Cartao> findbyidExterno(String idExterno);
}

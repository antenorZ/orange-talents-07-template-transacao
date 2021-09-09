package br.com.zup.transacoes.consumer;

import br.com.zup.transacoes.dto.TransacaoDto;
import br.com.zup.transacoes.model.Transacao;
import br.com.zup.transacoes.repository.TransacaoRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TransacaoConsumer {

    private static final Logger log = LoggerFactory.getLogger(TransacaoConsumer.class);

    @Value(value = "${spring.kafka.topic.transactions}")
    private String topic;

    @Value(value = "${spring.kafka.consumer.group-id}")
    private String groupId;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "transacoesKafkaListenerContainerFactory")
    public void ouveTopicoTransacoes(ConsumerRecord<String, TransacaoDto> record, @Payload TransacaoDto transacaoDto){
        log.info("Mensagem Recebida - Partição: " + record.partition());
        log.info("Mensagem Recebida - Valor: " + record.value());
        Transacao transacao = transacaoDto.toModel();
        transacaoRepository.save(transacao);
    }

}

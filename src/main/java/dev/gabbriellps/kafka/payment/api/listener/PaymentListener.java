package dev.gabbriellps.kafka.payment.api.listener;

import dev.gabbriellps.kafka.payment.api.dto.PaymentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentListener {


    @KafkaListener(topics = "${kafka.topic.payment.name}", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void saveTransaction(@Payload PaymentDTO paymentDTO) {
        log.info("PaymentListener ::: Transacao recebida {}", paymentDTO);
        log.info("PaymentListener ::: Salvando transacao no banco relacional ...");
    }

    @KafkaListener(topics = "${kafka.topic.payment.name}", groupId = "proof-group", containerFactory = "jsonContainerFactory")
    public void generatesProof(@Payload PaymentDTO paymentDTO) {
        log.info("PaymentListener ::: Gerando comprovante transacao id {} ...", paymentDTO.getId());
    }

    @KafkaListener(topics = "${kafka.topic.payment.name}", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(@Payload PaymentDTO paymentDTO) {
        log.info("PaymentListener ::: Enviando email aviso transacao id {} ...", paymentDTO.getId());
    }

}


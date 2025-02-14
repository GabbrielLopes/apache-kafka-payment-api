package dev.gabbriellps.kafka.payment.api.service;

import dev.gabbriellps.kafka.payment.api.dto.PaymentDTO;
import dev.gabbriellps.kafka.payment.api.service.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @Value("${kafka.topic.payment.name}")
    private String paymentTopicName;

    @SneakyThrows
    @Override
    public void sendPayment(PaymentDTO paymentDTO){
        log.info("PaymentServiceImpl ::: Realizando pagamento... {}", paymentDTO);
        paymentDTO.setId(UUID.randomUUID().toString());
        paymentDTO.setTransactionDate(LocalDateTime.now());
        Thread.sleep(1000);

        log.info("PaymentServiceImpl ::: Enviando dados ao topico do kafka...");
        kafkaTemplate.send(paymentTopicName, paymentDTO);
    }

}

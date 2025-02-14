package dev.gabbriellps.kafka.payment.api.service;

import dev.gabbriellps.kafka.payment.api.dto.PaymentDTO;
import dev.gabbriellps.kafka.payment.api.service.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void sendPayment(PaymentDTO paymentDTO){
        log.info("PaymentServiceImpl ::: Pagamento recebido {}", paymentDTO);
    }

}

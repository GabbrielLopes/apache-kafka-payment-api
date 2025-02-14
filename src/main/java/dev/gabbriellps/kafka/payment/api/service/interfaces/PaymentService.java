package dev.gabbriellps.kafka.payment.api.service.interfaces;

import dev.gabbriellps.kafka.payment.api.dto.PaymentDTO;

public interface PaymentService {

    void sendPayment(PaymentDTO paymentDTO);

}

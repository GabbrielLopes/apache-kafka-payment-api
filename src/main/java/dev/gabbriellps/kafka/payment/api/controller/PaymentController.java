package dev.gabbriellps.kafka.payment.api.controller;

import dev.gabbriellps.kafka.payment.api.dto.PaymentDTO;
import dev.gabbriellps.kafka.payment.api.service.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/payments")
@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final PaymentService paymentService;


    @PostMapping
    public ResponseEntity<PaymentDTO> payment(@RequestBody PaymentDTO requestDTO) {
        paymentService.sendPayment(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

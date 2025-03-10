package dev.gabbriellps.kafka.payment.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PaymentDTO implements Serializable {

    private String id;
    private String cardNumber;
    private String securityCode;
    private BigDecimal value;
    private LocalDateTime transactionDate;

}

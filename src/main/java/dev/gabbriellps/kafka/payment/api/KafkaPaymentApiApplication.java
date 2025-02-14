package dev.gabbriellps.kafka.payment.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class KafkaPaymentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPaymentApiApplication.class, args);
	}

}

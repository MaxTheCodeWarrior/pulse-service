package telran.java51.kafkaconsumer.pulse.service;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import telran.java51.kafkaconsumer.pulse.dto.PulseDto;

@Configuration
public class PulseService {

	@Bean
	Consumer<PulseDto> receiveData() {
		return data -> {
		
			long delay = System.currentTimeMillis() - data.getTimestamp();
			System.out.println("delay: " + delay + ", id: " + data.getId() + ", pulse: " + data.getPayload());
		};
	}
}

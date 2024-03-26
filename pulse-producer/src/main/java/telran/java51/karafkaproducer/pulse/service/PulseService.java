package telran.java51.karafkaproducer.pulse.service;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import telran.java51.karafkaproducer.pulse.dto.PulseDto;

@Configuration
public class PulseService {
	Random random = new Random();

	private int minId = 1;
	private int maxId = 10;
	private int minPulse = 1;
	private int maxPulse = 200;

	@Bean
	Supplier<PulseDto> sendData() {
		return () -> {
			int id = random.nextInt(minId, maxId);
			int payload = random.nextInt(minPulse, maxPulse);
			return new PulseDto(id, System.currentTimeMillis(), payload);
		};
	}

}

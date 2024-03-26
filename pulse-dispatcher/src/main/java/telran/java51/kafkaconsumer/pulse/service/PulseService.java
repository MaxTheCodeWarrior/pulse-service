package telran.java51.kafkaconsumer.pulse.service;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import telran.java51.kafkaconsumer.pulse.dto.PulseDto;

@RequiredArgsConstructor
@Configuration
public class PulseService {

	final StreamBridge streamBridge;
	
	@Value("${minpulse.value}")
	private int minPulse;
	@Value("${maxpulse.value}")
	private int maxPulse;

	@Bean
	Consumer<PulseDto> dispatchData() {
		return data -> {
			if (data.getPayload() < minPulse) {
				streamBridge.send("lowPulse-out-0", data);
				return;
			}
			if (data.getPayload() > maxPulse) {
				streamBridge.send("highPulse-out-0", data);
				return;
			}
			long delay = System.currentTimeMillis() - data.getTimestamp();
			System.out.println("delay: " + delay + ", id: " + data.getId() + ", pulse: " + data.getPayload());
		};
	}


}

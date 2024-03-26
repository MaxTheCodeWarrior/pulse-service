package telran.java51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PulseProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PulseProducerApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(PulseProducerApplication.class, args);
		try {
			Thread.sleep(30_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			context.close();
		}

	}

}

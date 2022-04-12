package co.com.trasportes.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"co.com.trasportes.web"})
public class TransportesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportesApplication.class, args);
	}

}

package br.com.jtech.services.manager.togaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.jtech.services.manager.togaf.config.infra.redis.RedisConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RedisConfiguration.class)
public class StartTogaf {

	public static void main(String[] args) {
		SpringApplication.run(StartTogaf.class, args);
	}

}

package br.com.jtech.services.togaf.adapters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.jtech.services.togaf.adapters.config.infra.redis.RedisConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RedisConfiguration.class)
public class StartAdapters {

	public static void main(String[] args) {
		SpringApplication.run(StartAdapters.class, args);
	}

}

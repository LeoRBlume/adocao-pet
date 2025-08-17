package br.com.adocao_pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SistemaDeAdocaoParaPetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeAdocaoParaPetApplication.class, args);
	}

}

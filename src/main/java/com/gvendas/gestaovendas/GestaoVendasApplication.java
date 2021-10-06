package com.gvendas.gestaovendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.gvendas.gestaovendas.entidades"})
@EnableJpaRepositories(basePackages = {"com.gvendas.gestaovendas.repositorio"})
@ComponentScan(basePackages = {"com.gvendas.gestaovendas.servive", "com.gvendas.gestaovendas.controlador", "com.gvendas.gestaovendas.execao"})
@SpringBootApplication
public class GestaoVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoVendasApplication.class, args);
	}

}

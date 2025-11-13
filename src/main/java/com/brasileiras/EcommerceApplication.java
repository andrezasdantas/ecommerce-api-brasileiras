package com.brasileiras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal para inicialização da aplicação Spring Boot.
 * @Autor: Andreza da Silva Dantas
 */
@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
        System.out.println("API E-commerce da BRASILEIRAS iniciada com sucesso!");
    }
}
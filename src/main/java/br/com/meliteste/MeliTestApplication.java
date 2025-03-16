package br.com.meliteste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MeliTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(MeliTestApplication.class, args);
    }
}

package br.com.meliteste.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@Configuration
@EnableRetry // Habilita o Spring Retry
public class RetryConfig {
    // Aqui você pode adicionar outras configurações, se necessário
}
package br.com.meliteste.config;

import br.com.meliteste.adapters.out.ExecuteGatewaysAdapter;
import br.com.meliteste.application.core.usecase.ExecuteGateways;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecuteGatewaysConfig {

    @Bean
    public ExecuteGateways executeGateways(ExecuteGatewaysAdapter executeGatewaysAdapter) {
        return new ExecuteGateways(executeGatewaysAdapter);
    }
}

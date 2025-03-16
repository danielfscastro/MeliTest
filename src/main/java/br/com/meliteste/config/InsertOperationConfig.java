package br.com.meliteste.config;

import br.com.meliteste.adapters.out.FindOperationByExternalIdAdapter;
import br.com.meliteste.adapters.out.InsertOperationAdapter;
import br.com.meliteste.application.core.usecase.InsertOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertOperationConfig {
    @Bean
    public InsertOperation insertOperation(InsertOperationAdapter insertOperationAdapter, FindOperationByExternalIdAdapter findOperationByExternalIdAdapter) {
        return new InsertOperation(insertOperationAdapter, findOperationByExternalIdAdapter);
    }
}

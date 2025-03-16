package br.com.meliteste.config;

import br.com.meliteste.adapters.out.FindOperationByExternalIdAdapter;
import br.com.meliteste.application.core.usecase.FindOperationsByExternalId;
import br.com.meliteste.application.core.usecase.InsertOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOperationsByExternalIdConfig {
    @Bean
    public FindOperationsByExternalId findOperationsByExternalId(FindOperationByExternalIdAdapter findOperationByExternalIdAdapter) {
        return new FindOperationsByExternalId(findOperationByExternalIdAdapter);
    }
}

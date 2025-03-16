package br.com.meliteste.adapters.out.gateway;

import br.com.meliteste.application.core.exception.ClientResponseStatusException;
import br.com.meliteste.application.ports.out.gateway.CancelAccountGateway;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class CancelAccountImpl implements CancelAccountGateway {

    public boolean cancel(long accountId) throws ClientResponseStatusException{
        System.out.println("tentando cancelar a conta");

        return true;
    }
};
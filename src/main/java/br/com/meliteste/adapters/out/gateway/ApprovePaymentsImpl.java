package br.com.meliteste.adapters.out.gateway;

import br.com.meliteste.application.core.exception.ClientResponseStatusException;
import br.com.meliteste.application.ports.out.gateway.ApprovePaymentsGateway;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class ApprovePaymentsImpl implements ApprovePaymentsGateway {

   public boolean approve(long paymentId) throws ClientResponseStatusException{
//      System.out.println("aprovou pagamento");
      return false;
   }
};
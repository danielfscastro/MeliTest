package br.com.meliteste.adapters.out.gateway;

import br.com.meliteste.application.core.exception.ClientResponseStatusException;
import br.com.meliteste.application.ports.out.gateway.RefundPaymentsGateway;
import org.springframework.stereotype.Component;

@Component
public class RefundPaymentsGatewayImpl implements RefundPaymentsGateway {

    public boolean refundPayment(long paymentId) throws ClientResponseStatusException{
      System.out.println("reembolsou pagamento");
      return false;
    }
};
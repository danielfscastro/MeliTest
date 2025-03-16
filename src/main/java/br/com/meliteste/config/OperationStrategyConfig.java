package br.com.meliteste.config;

import br.com.meliteste.adapters.out.gateway.ApplyDiscountPurchaseImpl;
import br.com.meliteste.adapters.out.gateway.ApprovePaymentsImpl;
import br.com.meliteste.adapters.out.gateway.CancelAccountImpl;
import br.com.meliteste.adapters.out.gateway.RefundPaymentsGatewayImpl;
import br.com.meliteste.application.core.domain.OperationType;
import br.com.meliteste.application.core.strategy.OperationStrategy;
import br.com.meliteste.application.core.strategy.impl.ApplyDiscountPurchaseStrategy;
import br.com.meliteste.application.core.strategy.impl.ApprovePaymentsStrategy;
import br.com.meliteste.application.core.strategy.impl.CancelAccountStrategy;
import br.com.meliteste.application.core.strategy.impl.RefundPaymentsStrategy;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@AllArgsConstructor
public class OperationStrategyConfig {

    private final ApprovePaymentsImpl approvePaymentsClient;
    private final ApplyDiscountPurchaseImpl applyDiscountPurchaseClient;
    private final CancelAccountImpl cancelAccountClient;
    private final RefundPaymentsGatewayImpl refundPaymentsClient;

    @Bean
    public Map<OperationType, OperationStrategy> operationStrategies() {
        return Map.ofEntries(
                Map.entry(OperationType.APPROVE_PAYMENTS, new ApprovePaymentsStrategy(approvePaymentsClient)),
                Map.entry(OperationType.APPLY_DISCOUNT_PURCHASE, new ApplyDiscountPurchaseStrategy(applyDiscountPurchaseClient)),
                Map.entry(OperationType.REFUND_PAYMENTS, new RefundPaymentsStrategy(refundPaymentsClient)),
                Map.entry(OperationType.CANCEL_ACCOUNT, new CancelAccountStrategy(cancelAccountClient))
        );
    }
}

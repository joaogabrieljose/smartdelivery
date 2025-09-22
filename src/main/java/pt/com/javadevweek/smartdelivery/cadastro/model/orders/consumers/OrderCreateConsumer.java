package pt.com.javadevweek.smartdelivery.cadastro.model.orders.consumers;

import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pt.com.javadevweek.smartdelivery.cadastro.infra.security.RabbitMQConfig;
import pt.com.javadevweek.smartdelivery.cadastro.model.dto.dtoOrders.OrderEvent;
import pt.com.javadevweek.smartdelivery.cadastro.model.orders.CreateDeliveryOrderUseCase;

@Slf4j
@Component
public class OrderCreateConsumer {

    private final CreateDeliveryOrderUseCase createDeliveryOrderUseCase;

    public OrderCreateConsumer(CreateDeliveryOrderUseCase createDeliveryOrderUseCase){
        this.createDeliveryOrderUseCase = createDeliveryOrderUseCase;
    }
    
    @RabbitListener(queues = RabbitMQConfig.QUEUE_ORDER_CREATED)
    public void listener(OrderEvent orderEvent){
        try {
            log.info("Chegou mensagem de pedido ", orderEvent.id());

            this.createDeliveryOrderUseCase.execute(UUID.fromString(orderEvent.id()));

            log.info(" Pedido {} processado com sucesso", orderEvent.id());

        } catch (IllegalArgumentException e) {
            log.warn("Pedido não encontrado para evento {}: {}", orderEvent.id(), e.getMessage());
        } catch (Exception e) {
            log.error("Erro inesperado ao processar pedido {}: {}", orderEvent.id(), e.getMessage(), e);
        }
    }
}

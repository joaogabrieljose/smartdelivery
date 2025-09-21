package pt.com.javadevweek.smartdelivery.cadastro.model.orders.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import pt.com.javadevweek.smartdelivery.cadastro.infra.security.RabbitMQConfig;
import pt.com.javadevweek.smartdelivery.cadastro.model.dto.dtoOrders.OrderEvent;

@Component
public class OrderCreateConsumer {
    
    @RabbitListener(queues = RabbitMQConfig.QUEUE_ORDER_CREATED)
    public void listener(OrderEvent orderEvent){
        System.out.println("chegou mensagem...");
        System.out.println(orderEvent.id());
    }
}

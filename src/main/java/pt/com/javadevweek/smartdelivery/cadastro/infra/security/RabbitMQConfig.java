package pt.com.javadevweek.smartdelivery.cadastro.infra.security;



import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_ORDER_CREATED = "pedido_criado";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_ORDER_CREATED, true);
    }
    
}

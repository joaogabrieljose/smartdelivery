package pt.com.javadevweek.smartdelivery.cadastro.model.orders;

import java.util.UUID;

import org.springframework.stereotype.Service;

import pt.com.javadevweek.smartdelivery.cadastro.model.deliveryman.DeliverManRepository;
import pt.com.javadevweek.smartdelivery.cadastro.model.deliveryman.DeliveryManEntity;
import pt.com.javadevweek.smartdelivery.cadastro.model.repository.OrdersRepository;

@Service
public class DeliveredUseCase {

    private OrdersRepository ordersRepository;
    private DeliverManRepository deliverManRepository;


    public DeliveredUseCase(OrdersRepository ordersRepository, DeliverManRepository deliverManRepository){
        this.deliverManRepository = deliverManRepository;
        this.ordersRepository = ordersRepository;
    }

    public void execute(UUID orderId){

        OrdersEntity ordersEntity = this.ordersRepository.findById(orderId).orElseThrow(()-> {
            throw new IllegalArgumentException("pedido não encontrado" );
        });

        ordersEntity.setStatus(StatusOrders.ENTREGUE);
        this.ordersRepository.save(ordersEntity);

        DeliveryManEntity deliveryManEntity = this.deliverManRepository.findById(ordersEntity.getDeliveryManId()).orElseThrow(()-> {
            throw new IllegalArgumentException("entregador não cadastrado...");
        });
        deliveryManEntity.setAvailable(true);
        this.deliverManRepository.save(deliveryManEntity);
    }
    
}

package pt.com.javadevweek.smartdelivery.cadastro.model.orders;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pt.com.javadevweek.smartdelivery.cadastro.model.deliveryman.DeliverManRepository;
import pt.com.javadevweek.smartdelivery.cadastro.model.deliveryman.DeliveryManEntity;
import pt.com.javadevweek.smartdelivery.cadastro.model.repository.OrdersRepository;

@Service
public class CreateDeliveryOrderUseCase {

    private OrdersRepository ordersRepository;
    private DeliverManRepository deliverManRepository;

    public CreateDeliveryOrderUseCase(OrdersRepository ordersRepository, DeliverManRepository deliverManRepository){
        this.ordersRepository = ordersRepository;
        this.deliverManRepository = deliverManRepository;
    }
    

   @Transactional
    public void execute(UUID orderId) {
        var orderEntity = ordersRepository.findById(orderId)
            .orElseThrow(() -> new IllegalArgumentException("o pedido não encontrado... " + orderId));

        List<DeliveryManEntity> available = deliverManRepository.findByIsAvailable(true);

        if (available.isEmpty()) {
            System.out.println("Nenhum deliveryman encontrado... " + orderId);
            return;
        }

        DeliveryManEntity firstDeliveryManEntity = available.getFirst();

        orderEntity.setDeliveryManEntity(firstDeliveryManEntity);
        orderEntity.setStatus(StatusOrders.EM_ROTA);
        ordersRepository.save(orderEntity);

        firstDeliveryManEntity.setAvailable(false);
        deliverManRepository.save(firstDeliveryManEntity);
    }
}

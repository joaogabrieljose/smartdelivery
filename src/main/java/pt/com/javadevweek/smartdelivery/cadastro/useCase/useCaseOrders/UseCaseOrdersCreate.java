package pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseOrders;

import org.springframework.stereotype.Service;

import pt.com.javadevweek.smartdelivery.cadastro.model.dto.dtoOrders.OrdersDTO;
import pt.com.javadevweek.smartdelivery.cadastro.model.dto.dtoOrders.OrdersMapper;
import pt.com.javadevweek.smartdelivery.cadastro.model.orders.OrdersEntity;
import pt.com.javadevweek.smartdelivery.cadastro.model.repository.OrdersRepository;

@Service
public class UseCaseOrdersCreate {

    private OrdersRepository ordersRepository;

    public UseCaseOrdersCreate(OrdersRepository ordersRepository){
        this.ordersRepository = ordersRepository;
    }

    public void execute(OrdersDTO ordersDTO){
        
        OrdersEntity entity = OrdersMapper.tOrdersEntity(ordersDTO);
        this.ordersRepository.save(entity);

    }
    
}

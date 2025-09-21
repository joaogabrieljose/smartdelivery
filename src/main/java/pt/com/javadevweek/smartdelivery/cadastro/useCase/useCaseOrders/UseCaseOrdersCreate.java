package pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseOrders;

import java.util.UUID;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pt.com.javadevweek.smartdelivery.cadastro.model.dto.dtoOrders.CreateOrdersResponse;
import pt.com.javadevweek.smartdelivery.cadastro.model.dto.dtoOrders.OrdersDTO;
import pt.com.javadevweek.smartdelivery.cadastro.model.dto.dtoOrders.OrdersMapper;
import pt.com.javadevweek.smartdelivery.cadastro.model.entityCostumer.CustomerEntity;
import pt.com.javadevweek.smartdelivery.cadastro.model.orders.OrdersEntity;
import pt.com.javadevweek.smartdelivery.cadastro.model.repository.CustomerRepository;
import pt.com.javadevweek.smartdelivery.cadastro.model.repository.OrdersRepository;
import pt.com.javadevweek.smartdelivery.cadastro.model.repository.UserRepository;
import pt.com.javadevweek.smartdelivery.cadastro.model.userEntity.UserEntity;

@Service
public class UseCaseOrdersCreate {

    private OrdersRepository ordersRepository;

    private UserRepository userRepository;

    private CustomerRepository customerRepository;


    public UseCaseOrdersCreate(OrdersRepository ordersRepository, UserRepository  userRepository, CustomerRepository customerRepository){
        this.ordersRepository = ordersRepository;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    public CreateOrdersResponse execute(OrdersDTO ordersDTO){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userEntity =  this.userRepository.findByUsername(username).get();

        CustomerEntity customerEntity = this.customerRepository.findByUserId(userEntity.getId()).get();



        OrdersEntity entity = OrdersMapper.tOrdersEntity(ordersDTO, customerEntity.getId());
        this.ordersRepository.save(entity);
        return new CreateOrdersResponse(entity.getId(), entity.getStatus().toString());
    }
    
}

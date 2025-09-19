package pt.com.javadevweek.smartdelivery.cadastro.model.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.com.javadevweek.smartdelivery.cadastro.model.orders.OrdersEntity;

public interface OrdersRepository extends JpaRepository<OrdersEntity, UUID>{
    
}

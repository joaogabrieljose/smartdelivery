package pt.com.javadevweek.smartdelivery.cadastro.model.dto.dtoOrders;

import java.util.List;
import java.util.UUID;

public record OrdersDTO(UUID customerId, List<UUID> producto) {
    
}

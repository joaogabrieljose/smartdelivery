package pt.com.javadevweek.smartdelivery.cadastro.model.dto.dtoOrders;

import java.util.UUID;

public record CreateOrdersResponse(UUID orderId, String status) {
    
}

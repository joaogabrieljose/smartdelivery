package pt.com.javadevweek.smartdelivery.cadastro.model.dto.dtoOrders;

import java.util.List;

import org.springframework.beans.BeanUtils;

import pt.com.javadevweek.smartdelivery.cadastro.model.entityProduct.Products;
import pt.com.javadevweek.smartdelivery.cadastro.model.orders.OrdersEntity;

public class OrdersMapper {

    public static OrdersEntity tOrdersEntity(OrdersDTO ordersDTO){

        OrdersEntity entity = new OrdersEntity();
        entity.setCustomerId(ordersDTO.customerId());
        
       List<Products> products = ordersDTO.producto().stream()
                .map(id -> {
                    Products prod = new Products();
                    prod.setId(id);
                    return prod;
                })
                .toList();
    
            entity.setProducto(products);
        return entity;
    }
    
}

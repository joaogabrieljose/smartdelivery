package pt.com.javadevweek.smartdelivery.cadastro.controller.ordersController;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.com.javadevweek.smartdelivery.cadastro.model.dto.dtoOrders.OrdersDTO;
import pt.com.javadevweek.smartdelivery.cadastro.model.orders.DeliveredUseCase;
import pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseOrders.UseCaseOrdersCreate;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private UseCaseOrdersCreate useCaseOrdersCreate;
    private DeliveredUseCase deliveredUseCase;

    public OrdersController(UseCaseOrdersCreate useCaseOrdersCreate, DeliveredUseCase deliveredUseCase){
        this.useCaseOrdersCreate = useCaseOrdersCreate;
        this.deliveredUseCase = deliveredUseCase;
    }


    @PostMapping("/")
    public ResponseEntity<?> created(@RequestBody OrdersDTO ordersDTO){
       var order = this.useCaseOrdersCreate.execute(ordersDTO);
       return ResponseEntity.ok().body(order);
    }

    @PutMapping("/deliverered/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String devivererd(@PathVariable UUID id){
        this.deliveredUseCase.execute(id);
        return "pedido entregue com sucesso";

    }
    
}

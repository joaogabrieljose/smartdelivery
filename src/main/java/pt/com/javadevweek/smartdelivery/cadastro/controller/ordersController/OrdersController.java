package pt.com.javadevweek.smartdelivery.cadastro.controller.ordersController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.com.javadevweek.smartdelivery.cadastro.model.dto.dtoOrders.OrdersDTO;
import pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseOrders.UseCaseOrdersCreate;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private UseCaseOrdersCreate useCaseOrdersCreate;

    public OrdersController(UseCaseOrdersCreate useCaseOrdersCreate){
        this.useCaseOrdersCreate = useCaseOrdersCreate;
    }


    @PostMapping("/")
    public ResponseEntity<?> created(@RequestBody OrdersDTO ordersDTO){
       var order = this.useCaseOrdersCreate.execute(ordersDTO);
       return ResponseEntity.ok().body(order);
    }
    
}

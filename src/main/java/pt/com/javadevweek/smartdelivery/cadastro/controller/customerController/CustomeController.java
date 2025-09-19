package pt.com.javadevweek.smartdelivery.cadastro.controller.customerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.com.javadevweek.smartdelivery.cadastro.model.entityCostumer.CustomerEntity;
import pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseCustomer.UseCaseCustumerCreate;

@RestController
@RequestMapping("/customer")
public class CustomeController {

   private UseCaseCustumerCreate useCaseCustumerCreate;

   public CustomeController(UseCaseCustumerCreate useCaseCustumerCreate){
    this.useCaseCustumerCreate = useCaseCustumerCreate;
   }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody CustomerEntity entity){
        this.useCaseCustumerCreate.execute(entity);
        return ResponseEntity.ok().build();
    }
    
}

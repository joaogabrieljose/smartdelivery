package pt.com.javadevweek.smartdelivery.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.com.javadevweek.smartdelivery.cadastro.model.entity.CustomerEntity;
import pt.com.javadevweek.smartdelivery.cadastro.useCase.UseCaseCustumerCreate;

@RestController
@RequestMapping("/customer")
public class CustomeController {
    
   private UseCaseCustumerCreate useCaseCustumerCreate;

   public CustomeController(UseCaseCustumerCreate useCaseCustumerCreate){
    this.useCaseCustumerCreate = useCaseCustumerCreate;
   }

    @PostMapping("/")
    public CustomerEntity create(@RequestBody CustomerEntity entity){
        this.useCaseCustumerCreate.execute(entity);
        return entity;
    }
    
}

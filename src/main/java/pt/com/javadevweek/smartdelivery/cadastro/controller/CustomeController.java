package pt.com.javadevweek.smartdelivery.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.com.javadevweek.smartdelivery.cadastro.model.entity.CustomerEntity;
import pt.com.javadevweek.smartdelivery.cadastro.useCase.UseCaseCustumerCreate;

@RestController
@RequestMapping("/customer")
public class CustomeController {


    @Autowired
    private UseCaseCustumerCreate useCase;


    @PostMapping("/")
    public CustomerEntity create(CustomerEntity entity){
        UseCaseCustumerCreate createted = new UseCaseCustumerCreate();
        createted.execute(entity);
        return entity;
    }
    
}

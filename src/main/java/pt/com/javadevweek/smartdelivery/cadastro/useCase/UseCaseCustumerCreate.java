package pt.com.javadevweek.smartdelivery.cadastro.useCase;

import org.springframework.stereotype.Service;

import pt.com.javadevweek.smartdelivery.cadastro.model.entity.CustomerEntity;

@Service
public class UseCaseCustumerCreate {

    public void execute(CustomerEntity entity){
        System.out.println(entity);
    }

    
}

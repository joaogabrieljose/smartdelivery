package pt.com.javadevweek.smartdelivery.cadastro.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import pt.com.javadevweek.smartdelivery.cadastro.model.entity.CustomerEntity;
import pt.com.javadevweek.smartdelivery.cadastro.model.repository.CustomerRepository;

@Service
public class UseCaseCustumerCreate {


    private CustomerRepository customerRepository;
    public UseCaseCustumerCreate (CustomerRepository repository){
        this.customerRepository = repository;
    }

    @Transactional
    public void execute(CustomerEntity entity){
        this.customerRepository.save(entity);
    }

    
}

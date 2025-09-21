package pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseCustomer;

import java.util.Optional;

import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.transaction.Transactional;
import pt.com.javadevweek.smartdelivery.cadastro.integrations.ViaCepDTO;
import pt.com.javadevweek.smartdelivery.cadastro.model.dto.customerDTO.CustomerRequest;
import pt.com.javadevweek.smartdelivery.cadastro.model.entityCostumer.CustomerEntity;
import pt.com.javadevweek.smartdelivery.cadastro.model.repository.CustomerRepository;
import pt.com.javadevweek.smartdelivery.cadastro.model.userEntity.Roles;
import pt.com.javadevweek.smartdelivery.cadastro.model.userEntity.UserEntity;
import pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseUser.UserCaseEntity;

@Service
public class UseCaseCustumerCreate {

    private final RestTemplate template = new RestTemplate();

    private CustomerRepository customerRepository;
    private UserCaseEntity userCaseEntity;

    public UseCaseCustumerCreate (CustomerRepository repository, UserCaseEntity userCaseEntity){
        this.customerRepository = repository;
        this.userCaseEntity = userCaseEntity;
    }

    @Transactional
    public void execute(CustomerRequest  customerRequest){

        String url = "https://viacep.com.br/ws/"+customerRequest.getZipCode()+"/json/";

        CustomerEntity entity = new CustomerEntity();

        try {
            ViaCepDTO viaCepDTO = template.getForObject(url, ViaCepDTO.class);
            entity.setAddress(viaCepDTO.getLogradouro());
        } catch (Exception e) {
            throw new IllegalArgumentException("erro ao consulta CEP "+ customerRequest.getZipCode());
        }

        UserEntity userEntity = this.userCaseEntity.execute(customerRequest.getEmail(),customerRequest.getPassword(), Roles.CUSTOMER);

        entity.setName(customerRequest.getName());
        entity.setPhone(customerRequest.getPhone());
        entity.setZipCode(customerRequest.getZipCode());
        entity.setEmail(customerRequest.getEmail());
        entity.setUserId(userEntity.getId());
        

       this.customerRepository.findByEmail(customerRequest.getEmail()).ifPresent(item -> {
                throw new IllegalArgumentException("Email já existe");
       });  
       
        this.customerRepository.save(entity);
    }

    
}

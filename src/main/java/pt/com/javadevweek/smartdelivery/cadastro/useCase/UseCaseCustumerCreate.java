package pt.com.javadevweek.smartdelivery.cadastro.useCase;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.transaction.Transactional;
import pt.com.javadevweek.smartdelivery.cadastro.model.dto.ViaCepDTO;
import pt.com.javadevweek.smartdelivery.cadastro.model.entity.CustomerEntity;
import pt.com.javadevweek.smartdelivery.cadastro.model.repository.CustomerRepository;

@Service
public class UseCaseCustumerCreate {

    private final RestTemplate template = new RestTemplate();

    private CustomerRepository customerRepository;

    public UseCaseCustumerCreate (CustomerRepository repository){
        this.customerRepository = repository;
    }

    @Transactional
    public void execute(CustomerEntity entity){

        String url = "https://viacep.com.br/ws/"+entity.getZipCode()+"/json/";

        try {
            ViaCepDTO viaCepDTO = template.getForObject(url, ViaCepDTO.class);
            entity.setAddress(viaCepDTO.getLogradouro());
        } catch (Exception e) {
            throw new IllegalArgumentException("erro ao consulta CEP "+ entity.getZipCode());
        }

        this.customerRepository.save(entity);
    }

    
}

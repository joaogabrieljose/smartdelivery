package pt.com.javadevweek.smartdelivery.cadastro.integrations.zipCode;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pt.com.javadevweek.smartdelivery.cadastro.integrations.ViaCepDTO;

@FeignClient(name = "viacep-service",  url = "https://viacep.com.br/ws/")
public interface ViaCepClient {

    @GetMapping("/{zipCode}/json")
    ViaCepDTO zipCode(@PathVariable("zipCode") String zipCode);
    
}

package pt.com.javadevweek.smartdelivery.cadastro.model.dto.customerDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    private String name;
    private String phone;
    private String email;
    private String zipCode;
    private String password;

    
}

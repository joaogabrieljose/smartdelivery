package pt.com.javadevweek.smartdelivery.cadastro.integrations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaCepDTO {
    private String cep;
    private String logradouro;
}

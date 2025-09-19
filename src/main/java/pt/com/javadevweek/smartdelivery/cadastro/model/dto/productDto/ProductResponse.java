package pt.com.javadevweek.smartdelivery.cadastro.model.dto.productDto;

import java.util.UUID;

public record ProductResponse(String code, String name, UUID id) {
    
}

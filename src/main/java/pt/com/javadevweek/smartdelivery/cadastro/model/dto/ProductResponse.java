package pt.com.javadevweek.smartdelivery.cadastro.model.dto;

import java.util.UUID;

public record ProductResponse(String code, String name, UUID id) {
    
}

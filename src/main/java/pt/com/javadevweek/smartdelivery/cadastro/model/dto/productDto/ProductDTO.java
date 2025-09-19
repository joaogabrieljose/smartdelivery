package pt.com.javadevweek.smartdelivery.cadastro.model.dto.productDto;

import java.util.UUID;

import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pt.com.javadevweek.smartdelivery.cadastro.model.entityProduct.Products;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
     private UUID id;
     private String code;
    private String name;
    private String description;
    private double price;

    

}

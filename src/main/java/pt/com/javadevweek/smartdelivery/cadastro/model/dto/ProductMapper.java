package pt.com.javadevweek.smartdelivery.cadastro.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import pt.com.javadevweek.smartdelivery.cadastro.model.entityProduct.Products;

public class ProductMapper {

    public static List<ListProductResponse> toResponse(List<Products> entity){
        return entity.stream().
            map(product -> new ListProductResponse(product.getCode(), product.getDescription(), product.getName(), product.getPrice()))
            .collect(Collectors.toList());
    }
}

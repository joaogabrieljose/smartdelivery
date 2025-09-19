package pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseProducts;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pt.com.javadevweek.smartdelivery.cadastro.model.dto.ListProductResponse;
import pt.com.javadevweek.smartdelivery.cadastro.model.dto.ProductDTO;
import pt.com.javadevweek.smartdelivery.cadastro.model.dto.ProductMapper;
import pt.com.javadevweek.smartdelivery.cadastro.model.entityProduct.Products;
import pt.com.javadevweek.smartdelivery.cadastro.model.repository.ProductRepository;

@Service
public class UseCaseProductFindAll {

    private ProductRepository productRepository;

    public UseCaseProductFindAll(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    
    public List<ListProductResponse> findAll(){
        var product = this.productRepository.findAll();
        return ProductMapper.toResponse(product);
        
    }
    
}

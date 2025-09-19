package pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseProducts;

import java.util.List;

import org.springframework.stereotype.Service;

import pt.com.javadevweek.smartdelivery.cadastro.model.dto.productDto.ListProductResponse;
import pt.com.javadevweek.smartdelivery.cadastro.model.dto.productDto.ProductMapper;
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

package pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseProducts;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pt.com.javadevweek.smartdelivery.cadastro.model.dto.ProductDTO;
import pt.com.javadevweek.smartdelivery.cadastro.model.entityProduct.Products;
import pt.com.javadevweek.smartdelivery.cadastro.model.repository.ProductRepository;

@Service
public class UseCaseCreateProducts {

    private ProductRepository productRepository;

    public UseCaseCreateProducts(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductDTO executeProducts(Products product) {
        this.productRepository.findByCode(product.getCode()).ifPresent(item -> {
            throw new IllegalArgumentException("Código já existe");
        });

        var prod = this.productRepository.save(product);
        return new ProductDTO(prod);
    }
    
}

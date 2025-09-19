package pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseProducts;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pt.com.javadevweek.smartdelivery.cadastro.model.dto.ProductDTO;
import pt.com.javadevweek.smartdelivery.cadastro.model.dto.ProductResponse;
import pt.com.javadevweek.smartdelivery.cadastro.model.entityProduct.Products;
import pt.com.javadevweek.smartdelivery.cadastro.model.repository.ProductRepository;

@Service
public class UseCaseCreateProducts {

    private ProductRepository productRepository;

    public UseCaseCreateProducts(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductResponse executeProducts(ProductDTO dto) {
        this.productRepository.findByCode(dto.getCode()).ifPresent(item -> {
            throw new IllegalArgumentException("Código já existe");
        });

        Products product = new Products();
        BeanUtils.copyProperties(dto, product);
        Products prod = this.productRepository.save(product);

        return new ProductResponse(prod.getCode(), prod.getName(), prod.getId());
    }
    
}

package pt.com.javadevweek.smartdelivery.cadastro.controller.productController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.com.javadevweek.smartdelivery.cadastro.model.dto.ProductDTO;
import pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseProducts.UseCaseCreateProducts;

@RestController
@RequestMapping("/product")
public class ProductControllerCreate {

    private UseCaseCreateProducts useCaseCreateProducts;

    public ProductControllerCreate(UseCaseCreateProducts useCaseCreateProducts){
        this.useCaseCreateProducts = useCaseCreateProducts;
    }


    @PostMapping("/")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO dto){

        try {
            var product = this.useCaseCreateProducts.executeProducts(dto);
            return ResponseEntity.ok().body(product);            
        } catch (Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

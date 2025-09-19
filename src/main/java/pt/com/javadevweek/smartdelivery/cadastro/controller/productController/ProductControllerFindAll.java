package pt.com.javadevweek.smartdelivery.cadastro.controller.productController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseProducts.UseCaseProductFindAll;

@RestController
@RequestMapping("/product")
public class ProductControllerFindAll {

    private UseCaseProductFindAll useCaseProductFindAll;

    public ProductControllerFindAll(UseCaseProductFindAll useCaseProductFindAll){
        this.useCaseProductFindAll = useCaseProductFindAll;
    }


    @GetMapping("/")
    public ResponseEntity<?> findAllProduct(){
        var produ = this.useCaseProductFindAll.findAll();
        return ResponseEntity.ok().body(produ);
    }
    
}

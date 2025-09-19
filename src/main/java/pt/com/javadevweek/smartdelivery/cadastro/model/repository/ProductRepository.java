package pt.com.javadevweek.smartdelivery.cadastro.model.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.com.javadevweek.smartdelivery.cadastro.model.entityProduct.Products;


@Repository
public interface ProductRepository extends JpaRepository<Products, UUID>{
    Optional<Products>findByDescription(String descriptioString);
    
}

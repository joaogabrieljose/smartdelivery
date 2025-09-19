package pt.com.javadevweek.smartdelivery.cadastro.model.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.com.javadevweek.smartdelivery.cadastro.model.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID>{
    Optional<CustomerEntity> findByEmail(String email);
}

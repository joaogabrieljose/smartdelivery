package pt.com.javadevweek.smartdelivery.cadastro.model.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.com.javadevweek.smartdelivery.cadastro.model.userEntity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID>{
    
    Optional<UserEntity> findByUsername(String username);
}

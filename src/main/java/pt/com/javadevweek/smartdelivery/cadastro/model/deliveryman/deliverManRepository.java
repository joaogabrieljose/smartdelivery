package pt.com.javadevweek.smartdelivery.cadastro.model.deliveryman;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliverManRepository extends JpaRepository<DeliveryManEntity, UUID> {
    Optional<DeliveryManEntity> findByDocument(String document);
}

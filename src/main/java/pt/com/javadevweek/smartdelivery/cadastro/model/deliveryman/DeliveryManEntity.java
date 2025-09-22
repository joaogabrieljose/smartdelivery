package pt.com.javadevweek.smartdelivery.cadastro.model.deliveryman;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_delivery_man")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryManEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String document;
    private String phone;

   @Column(columnDefinition = "BOOLEAN DEFAULT true")
    @Builder.Default
    private boolean isAvailable = true;


}

package pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseDelivery;

import org.springframework.stereotype.Service;

import pt.com.javadevweek.smartdelivery.cadastro.model.deliveryman.DeliverManRepository;
import pt.com.javadevweek.smartdelivery.cadastro.model.deliveryman.DeliveryManEntity;
import pt.com.javadevweek.smartdelivery.cadastro.model.deliveryman.dto.CreateDeliveryManRequest;

@Service
public class UseCaseDeliveryMan {

    private DeliverManRepository deliverManRepository;

    public UseCaseDeliveryMan(DeliverManRepository deliverManRepository){
        this.deliverManRepository = deliverManRepository;
    }


    public void execute(CreateDeliveryManRequest deliveryManRequest){

        this.deliverManRepository.findByDocument(deliveryManRequest.document()).ifPresent(use -> {
            throw new IllegalArgumentException("entregador já cadastrado...");
        });

        DeliveryManEntity entity = new DeliveryManEntity().builder()
            .name(deliveryManRequest.name())
            .document(deliveryManRequest.document())
            .phone(deliveryManRequest.phone())
            .build();
            this.deliverManRepository.save(entity);
    }

    
}

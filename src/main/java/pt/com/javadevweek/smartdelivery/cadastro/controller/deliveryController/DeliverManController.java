package pt.com.javadevweek.smartdelivery.cadastro.controller.deliveryController;

import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.com.javadevweek.smartdelivery.cadastro.model.deliveryman.dto.CreateDeliveryManRequest;
import pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseDelivery.UseCaseDeliveryMan;

@RestController
@RequestMapping("/deliveryman")
public class DeliverManController {

    private UseCaseDeliveryMan deliveryMan;

    public DeliverManController(UseCaseDeliveryMan useCaseDeliveryMan){
        this.deliveryMan = useCaseDeliveryMan;
    }
    

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public UUID create(@RequestBody CreateDeliveryManRequest request){

        var delivery = this.deliveryMan.execute(request);
        return delivery;

    }
}

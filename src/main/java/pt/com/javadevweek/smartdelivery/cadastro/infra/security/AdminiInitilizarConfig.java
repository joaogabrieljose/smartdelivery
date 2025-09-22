package pt.com.javadevweek.smartdelivery.cadastro.infra.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pt.com.javadevweek.smartdelivery.cadastro.model.userEntity.Roles;
import pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseUser.UserCaseEntity;

@Configuration
public class AdminiInitilizarConfig {
    
    //@Bean
    public CommandLineRunner initAdmin(UserCaseEntity userCaseEntity){
        return args -> {
            userCaseEntity.execute("admin@smartdelivery.com", "admin123", Roles.ADMIN);
        };

    }
    
}

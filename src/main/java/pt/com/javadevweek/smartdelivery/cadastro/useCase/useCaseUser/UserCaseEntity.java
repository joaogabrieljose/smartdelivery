package pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseUser;



import org.springframework.stereotype.Service;

import pt.com.javadevweek.smartdelivery.cadastro.model.repository.UserRepository;
import pt.com.javadevweek.smartdelivery.cadastro.model.userEntity.Roles;
import pt.com.javadevweek.smartdelivery.cadastro.model.userEntity.UserEntity;

@Service
public class UserCaseEntity {

    private UserRepository userRepository;

    public UserCaseEntity(UserRepository userRepository){
        this.userRepository = userRepository;
    }

     public UserEntity execute(String username, String password, Roles role){

        this.userRepository.findByUsername(username).ifPresent(item -> {
            throw new IllegalArgumentException("username já cadastrado");
        });

        UserEntity entity = new UserEntity(
            username,
            password, 
            role
        );
        
        return this.userRepository.save(entity);
    }
    
}

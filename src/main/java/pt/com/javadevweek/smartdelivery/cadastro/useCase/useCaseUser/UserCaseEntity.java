package pt.com.javadevweek.smartdelivery.cadastro.useCase.useCaseUser;



import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pt.com.javadevweek.smartdelivery.cadastro.model.repository.UserRepository;
import pt.com.javadevweek.smartdelivery.cadastro.model.userEntity.Roles;
import pt.com.javadevweek.smartdelivery.cadastro.model.userEntity.UserEntity;

@Service
public class UserCaseEntity {

    private UserRepository userRepository;

    private final PasswordEncoder encoder;

    public UserCaseEntity(UserRepository userRepository, PasswordEncoder encoder){
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

     public UserEntity execute(String username, String password, Roles role){

        this.userRepository.findByUsername(username).ifPresent(item -> {
            throw new IllegalArgumentException("username já cadastrado");
        });
        
        String passwordEncoder = this.encoder.encode(password);

        UserEntity entity = new UserEntity(
            username,
            passwordEncoder, 
            role
        );
        
        return this.userRepository.save(entity);
    }
    
}

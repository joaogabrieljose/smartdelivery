package pt.com.javadevweek.smartdelivery.cadastro.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import pt.com.javadevweek.smartdelivery.cadastro.model.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
       http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers(HttpMethod.POST, "/customer/").permitAll()
                    // .requestMatchers(HttpMethod.POST, "/product/").permitAll()
                    // .requestMatchers(HttpMethod.GET, "/product/").permitAll()
                    // .requestMatchers(HttpMethod.POST, "/orders/").permitAll()
                    
                    .anyRequest().authenticated()) 
                .httpBasic(Customizer.withDefaults())  ;
        return http.build();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new  BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService(){
        return  username ->this.userRepository.findByUsername(username)
                .map(user -> User.withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRole().name())
                    .build())
            .orElseThrow(()-> new RuntimeException("usuario/incorreta"));
        
    }

    
}

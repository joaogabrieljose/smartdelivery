package pt.com.javadevweek.smartdelivery.cadastro.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
       http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers(HttpMethod.POST, "/customer/").permitAll()
                    .requestMatchers(HttpMethod.POST, "/product/").permitAll()
                    .requestMatchers(HttpMethod.GET, "/product/").permitAll()
                    .requestMatchers(HttpMethod.POST, "/orders/").permitAll()
                    
                    .anyRequest().authenticated())   ;
        return http.build();
    }
    
}

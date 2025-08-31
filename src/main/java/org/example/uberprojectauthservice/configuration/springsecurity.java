package org.example.uberprojectauthservice.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity
public class springsecurity  {

   @Bean

   public DefaultSecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return http
               .csrf(csrf-> csrf.disable())
               .authorizeHttpRequests(auth->
                       auth
                               .requestMatchers("/api/v1/auth/signUp/*").permitAll()
               .requestMatchers("/api/v1/auth/signin/*").permitAll()
               )
               .build();
   }

    @Bean  // java object
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return  new BCryptPasswordEncoder();
    }
}

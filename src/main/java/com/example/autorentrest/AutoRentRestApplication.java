package com.example.autorentrest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AutoRentRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoRentRestApplication.class, args);
    }
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

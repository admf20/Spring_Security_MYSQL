package com.example.SpringSecurity_BD.init;

import com.example.SpringSecurity_BD.model.Role;
import com.example.SpringSecurity_BD.model.User;
import com.example.SpringSecurity_BD.repository.RoleRepository;
import com.example.SpringSecurity_BD.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(RoleRepository roleRepository, UserRepository userRepository){
        return args -> {
            // 1. Crear roles si no existen
            Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElseGet(() -> roleRepository.save(new Role("ROLE_ADMIN")));
            Role userRole = roleRepository.findByName("ROLE_USER").orElseGet(() -> roleRepository.save(new Role("ROLE_USER")));

            // 2. Codificador de contraseñas
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            // 3. Crear usuario admin si no existe
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User(
                        "admin",
                        encoder.encode("admin123"),
                        adminRole
                );
                userRepository.save(admin);
            }

            // 4. Crear usuario normal si no existe
            if (userRepository.findByUsername("user").isEmpty()) {
                User user = new User(
                        "user",
                        encoder.encode("user123"),
                        userRole
                );
                userRepository.save(user);
            }

            System.out.println("✅ Datos iniciales cargados.");
        };
    }
}

package com.example.SpringSecurity_BD.security;

import com.example.SpringSecurity_BD.model.User;
import com.example.SpringSecurity_BD.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Buscando usuario: " + username);
        //busca el rol
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("Usuario no encontrado" + username);
                });

        //busca el username
        //User Userpassword = userRepository.finByPassword(password).orElseThrow(null);
        System.out.println("Resultado final: " + user.getRole().getName());

        return new UserDetailsImpl(user);
    }
}

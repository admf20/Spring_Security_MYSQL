package com.example.SpringSecurity_BD.security;

import com.example.SpringSecurity_BD.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**Esta clase convierte nuestra entidad User en un objeto que Spring Security
 * pueda entender, por medio de los metodos que ya tiene UserDetails.
 */
public class UserDetailsImpl implements UserDetails {

    private final User user;
    //inyectamos la entidad usurio
    public UserDetailsImpl(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //Spring Security trabaja con la interfaz GrantedAuthority, pero necesita una implementación concreta
        // que es SimpleGrantedAuthority simplemente encapsula un string (el nombre del rol o permiso), y Spring ya sabe procesarla.
        //ya despues se retorna un Collections.singleton ya que es un solo dato
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole().getName()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
}

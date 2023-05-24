package com.Theowns.config;

import com.Theowns.Repositories.UserRepository;
import com.Theowns.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel userModel = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email" + email + " No existe"));

        return new UserDetailsImpl(userModel);
    }
}

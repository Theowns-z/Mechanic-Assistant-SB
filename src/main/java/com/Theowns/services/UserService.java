package com.Theowns.services;

import com.Theowns.DTO.AuthenticationRequest;
import com.Theowns.models.UserModel;
import com.Theowns.repositories.UserRepository;
import com.Theowns.services.exceptions.DuplicateException;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    public List<UserModel> getAll() {
        return (List<UserModel>) userRepository.findAll();
    }

    public UserModel getOne(Long id) throws ExceptionObjectNotFound {
        return userRepository.findById(id).orElseThrow(()->new ExceptionObjectNotFound("User no encontrado"));
    }


    public UserModel save(UserModel user) throws DuplicateException {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateException("El correo electrónico ya está registrado");
        }

        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        return userRepository.save(user);
    }

    public UserModel update(AuthenticationRequest userNuevo) throws ExceptionObjectNotFound {
        UserModel user = userRepository
                .findByEmail(userNuevo.getEmail())
                .orElseThrow(()->new ExceptionObjectNotFound("User no encontrado"));

        String encryptedPassword = passwordEncoder.encode(userNuevo.getPassword());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

}

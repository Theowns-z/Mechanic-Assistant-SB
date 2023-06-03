package com.Theowns.services;

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

    public UserModel update(Long id,UserModel userNuevo) throws ExceptionObjectNotFound {
        UserModel user = userRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("User no encontrado"));

        user.setEmail(userNuevo.getEmail());
        user.setPassword(userNuevo.getPassword());
        return userRepository.save(user);

    }


    public String delete(Long id) throws ExceptionObjectNotFound {
        UserModel user = userRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("User no encontrado"));

        userRepository.delete(user);
        return "User con ID " + id + " eliminado satisfactoriamente";

    }
}

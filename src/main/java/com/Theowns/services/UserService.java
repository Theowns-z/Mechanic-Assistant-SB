package com.Theowns.services;

import com.Theowns.models.UserModel;
import com.Theowns.repositories.UserRepository;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import com.Theowns.services.interfaces.InterfaceService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements InterfaceService<UserModel> {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserModel> getAll() {
        return (List<UserModel>) userRepository.findAll();
    }

    @Override
    public UserModel getOne(Long id) throws ExceptionObjectNotFound {
        return userRepository.findById(id).orElseThrow(()->new ExceptionObjectNotFound("User no encontrado"));
    }

    @Override
    public UserModel save(UserModel user) {
        if(!userRepository.existsByEmail(user.getEmail())) {
            String contraEncriptada = passwordEncoder.encode(user.getPassword());
            user.setPassword(contraEncriptada);
            return userRepository.save(user);
        }else {
            return null;
        }
    }

    @Override
    public UserModel update(Long id,UserModel userNuevo) throws ExceptionObjectNotFound {
        UserModel user = userRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("User no encontrado"));

        user.setEmail(userNuevo.getEmail());
        user.setPassword(userNuevo.getPassword());
        return userRepository.save(user);

    }

    @Override
    public String delete(Long id) throws ExceptionObjectNotFound {
        UserModel user = userRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("User no encontrado"));

        userRepository.delete(user);
        return "User con ID " + id + " eliminado satisfactoriamente";

    }
}

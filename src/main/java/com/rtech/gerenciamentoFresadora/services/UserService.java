package com.rtech.gerenciamentoFresadora.services;

import com.rtech.gerenciamentoFresadora.entities.User;
import com.rtech.gerenciamentoFresadora.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    //READ
    public List<User> findAll(){
        return userRepository.findAll();
    }

    //FIND BY ID
    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }

    //CREATE
    public User createUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    //UPDATE
    public User updateUser(Long id, User userDetails){

        User user = userRepository.findById(id).get();
        user.setLogin(userDetails.getLogin());
        user.setPassword(encoder.encode(userDetails.getPassword()));
        return userRepository.save(user);
    }

    //DELETE
    public void deleteUser(Long id){

        userRepository.deleteById(id);
    }



}

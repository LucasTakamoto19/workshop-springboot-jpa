package com.projetoudemy.curso.services;

import com.projetoudemy.curso.entities.User;
import com.projetoudemy.curso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User>findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }

    public User inserir(User obj){
        return userRepository.save(obj);
    }

    public void excluir(Long id){
        userRepository.deleteById(id);
    }

    public User atualizar(Long id, User obj){
        User entity = userRepository.getReferenceById(id);
        atualizarDados(entity, obj);
        return userRepository.save(entity);
    }

    private void atualizarDados(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}

package com.projetoudemy.curso.services;

import com.projetoudemy.curso.entities.Categoria;
import com.projetoudemy.curso.entities.User;
import com.projetoudemy.curso.repository.CategoriaRepository;
import com.projetoudemy.curso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria>findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.get();
    }
}

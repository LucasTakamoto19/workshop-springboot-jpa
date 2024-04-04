package com.projetoudemy.curso.services;

import com.projetoudemy.curso.entities.Produto;
import com.projetoudemy.curso.entities.User;
import com.projetoudemy.curso.repository.ProdutoRepository;
import com.projetoudemy.curso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto>findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Long id){
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.get();
    }
}

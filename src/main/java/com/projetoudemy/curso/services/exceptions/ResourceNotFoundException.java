package com.projetoudemy.curso.services.exceptions;

import java.util.Objects;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(Object id){
        super("Recurso não encontrado. Id " + id);
    }
}

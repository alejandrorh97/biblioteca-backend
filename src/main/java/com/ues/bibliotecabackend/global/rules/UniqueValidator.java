package com.ues.bibliotecabackend.global.rules;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.ues.bibliotecabackend.Usuario.UsuarioRepository;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void initialize(Unique unique) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !usuarioRepository.existsByCorreo(value);
    }
}

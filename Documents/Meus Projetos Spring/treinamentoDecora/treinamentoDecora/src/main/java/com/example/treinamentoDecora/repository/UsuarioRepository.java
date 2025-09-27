package com.example.treinamentoDecora.repository;

import com.example.treinamentoDecora.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,UUID > {
}

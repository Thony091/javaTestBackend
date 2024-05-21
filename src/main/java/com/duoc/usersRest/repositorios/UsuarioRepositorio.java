package com.duoc.usersRest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.usersRest.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
  
}

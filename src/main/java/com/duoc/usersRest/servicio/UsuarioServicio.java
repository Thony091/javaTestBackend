package com.duoc.usersRest.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.usersRest.modelo.Usuario;
import com.duoc.usersRest.repositorios.UsuarioRepositorio;
import com.duoc.usersRest.servicio.Interfaces.IUsuarioServicio;

@Service
public class UsuarioServicio implements IUsuarioServicio{

  @Autowired
  private UsuarioRepositorio usuarioRepositorio;

  @Override
  public List<Usuario> listarUsuarios() {
    return usuarioRepositorio.findAll();
  }

  @Override
  public Usuario buscarUsuarioPorId(Integer idUser) {

    Usuario usuario = usuarioRepositorio.findById(idUser).orElse(null);
    return usuario;
  }

  @Override
  public Usuario guardarUsuario(Usuario usuario) {
    return usuarioRepositorio.save(usuario);
  }

  @Override
  public Usuario editarUsuario(Usuario usuario) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'editUsuario'");
  }

  @Override
  public void eliminarUsuario(Integer idUser) {
    usuarioRepositorio.deleteById(idUser);
  }
  
}

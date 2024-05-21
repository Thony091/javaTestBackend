package com.duoc.usersRest.servicio.Interfaces;

import java.util.List;

import com.duoc.usersRest.modelo.Usuario;

public interface IUsuarioServicio  {

  public List<Usuario> listarUsuarios();
  public Usuario buscarUsuarioPorId(Integer idUser);
  public Usuario guardarUsuario(Usuario usuario);
  public Usuario editarUsuario(Usuario usuario);
  public void eliminarUsuario(Integer idUser);
  
}

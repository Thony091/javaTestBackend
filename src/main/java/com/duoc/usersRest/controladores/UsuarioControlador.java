package com.duoc.usersRest.controladores;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.duoc.usersRest.modelo.Usuario;
import com.duoc.usersRest.servicio.Interfaces.IUsuarioServicio;

import java.util.List;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("user-rest")
@CrossOrigin(value = "http://localhost:4200")
public class UsuarioControlador {
  
  private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioControlador.class);

  @Autowired
  private IUsuarioServicio usuarioServicio;

  @GetMapping("/listar")
  public List<Usuario> listarUsuarios() {
    var usuarios = usuarioServicio.listarUsuarios();
    usuarios.forEach(usuario -> logger.info(usuario.toString())); 
    return usuarios;
  }

}

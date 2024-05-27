package com.duoc.usersRest.controladores;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.usersRest.modelo.Message;
import com.duoc.usersRest.servicio.Interfaces.IMessageService;

import java.util.List;

import ch.qos.logback.classic.Logger;
@RestController
@RequestMapping("message-rest")
@CrossOrigin(value = "http://localhost:8080")
public class MessageController {
    
    private static final Logger logger = (Logger) LoggerFactory.getLogger(MessageController.class);
  
    @Autowired
    private IMessageService messageService;
  
    @GetMapping("/listar-mensajes")
    public List<Message> listarMensajes() {
      var messages = messageService.showMessages();
      messages.forEach( message  -> logger.info(message.toString())); 
      return messages;
    }
  
    @GetMapping("/obtener-mensaje/{id}")
    public Message obtenerMensaje(@PathVariable Integer id) {
      var message = messageService.SearchMessageById(id);
      logger.info(message.toString());
      return message;
    }

    @PostMapping("/crear-mensaje")
    public Message crearMensaje(@RequestBody Message message) {
      var messageCreated = messageService.saveMessage(message);
      logger.info(messageCreated.toString());
      return messageCreated;
    }

    @DeleteMapping("/eliminar-mensaje/{id}")
    public void eliminarMensaje(@PathVariable Integer id) {
      messageService.dropMessage(id);
    }
}

package com.duoc.usersRest.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.usersRest.modelo.Message;
import com.duoc.usersRest.repositorios.MessageRepository;
import com.duoc.usersRest.servicio.Interfaces.IMessageService;

@Service
public class MessageService implements IMessageService{

  @Autowired
  private MessageRepository messageRepository;

  @Override
  public List<Message> showMessages() {
    return messageRepository.findAll();
  }

  @Override
  public Message SearchMessageById(Integer idMessage) {
    Message message = messageRepository.findById(idMessage).orElse(null);
    return message;
  }

  @Override
  public Message saveMessage(Message message) {
    return messageRepository.save(message);
  }

  @Override
  public Message editMessage(Message message) {
    Message messageToEdit = messageRepository.findById(message.getId()).orElse(null);
    messageToEdit.setName(message.getName());
    messageToEdit.setEmail(message.getEmail());
    messageToEdit.setMessage(message.getMessage());
    return messageRepository.save(message);
  }

  @Override
  public void dropMessage(Integer idMessage) {
    messageRepository.deleteById(idMessage);
  }
  
}

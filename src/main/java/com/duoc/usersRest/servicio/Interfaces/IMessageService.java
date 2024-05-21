package com.duoc.usersRest.servicio.Interfaces;

import java.util.List;

import com.duoc.usersRest.modelo.Message;


public interface IMessageService {

  public List<Message> showMessages();
  public Message SearchMessageById(Integer idMessage);
  public Message saveMessage(Message message);
  public Message editMessage(Message message);
  public void dropMessage(Integer idMessage);

}

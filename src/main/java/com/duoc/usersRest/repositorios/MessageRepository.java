package com.duoc.usersRest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.usersRest.modelo.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{
  
}

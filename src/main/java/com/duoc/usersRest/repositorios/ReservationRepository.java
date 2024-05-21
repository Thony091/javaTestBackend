package com.duoc.usersRest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.usersRest.modelo.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
  
}

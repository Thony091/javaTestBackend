package com.duoc.usersRest.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.usersRest.modelo.Reservation;
import com.duoc.usersRest.repositorios.ReservationRepository;
import com.duoc.usersRest.servicio.Interfaces.IReservationService;

@Service
public class ReservationService implements IReservationService{

  @Autowired
  private ReservationRepository reservationRepository;
  
  @Override
  public List<Reservation> showReservations() {
    return reservationRepository.findAll();
  }

  @Override
  public Reservation searchReservationById(Integer idReservation) {
    Reservation reservation = reservationRepository.findById(idReservation).orElse(null);
    return reservation;
  }

  @Override
  public Reservation saveReservation(Reservation reservation) {
    return reservationRepository.save(reservation);
  }

  @Override
  public Reservation editReservation(Reservation reservation) {
    Reservation reservationToEdit = reservationRepository.findById( reservation.getId() ).orElse(null);
    reservationToEdit.setName(reservation.getName());
    reservationToEdit.setReservationDate(reservation.getReservationDate());
    reservationToEdit.setHoraReserva(reservation.getHoraReserva());
    reservationToEdit.setServiceName(reservation.getServiceName());
    return reservationRepository.save(reservation);
  }

  @Override
  public void dropReservation(Integer idReservation) {
    reservationRepository.deleteById(idReservation);
  }
  
}

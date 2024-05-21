package com.duoc.usersRest.controladores;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.usersRest.modelo.Reservation;
import com.duoc.usersRest.servicio.Interfaces.IReservationService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("reservation-rest")
@CrossOrigin(value = "http://localhost:8080")
public class ReservationController {
  
  private static final Logger logger = (Logger) LoggerFactory.getLogger(ReservationController.class);

  @Autowired
  private IReservationService reservationService;
  
  @GetMapping("/listar-reservas")
  public List<Reservation> listarReservas() {
    var reservations = reservationService.showReservations();
    reservations.forEach( reservation  -> logger.info(reservation.toString())); 
    return reservations;
  }

  @GetMapping("/obtener-reserva/{id}")
  public Reservation obtenerReserva(@PathVariable Integer id) {
    var reservation = reservationService.searchReservationById(id);
    logger.info(reservation.toString());
    return reservation;
  }
  
  @PostMapping("/crear-reserva")
  public Reservation crearReserva(Reservation reservation) {
    var reservationCreated = reservationService.saveReservation(reservation);
    logger.info(reservationCreated.toString());
    return reservationCreated;
  }

  @DeleteMapping("/eliminar-reserva/{id}")
  public void eliminarReserva(@PathVariable Integer id) {
    reservationService.dropReservation(id);
  }
}

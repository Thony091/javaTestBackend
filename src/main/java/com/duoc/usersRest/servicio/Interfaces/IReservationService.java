package com.duoc.usersRest.servicio.Interfaces;

import java.util.List;

import com.duoc.usersRest.modelo.Reservation;

public interface IReservationService {
    
    public List<Reservation> showReservations();
    public Reservation searchReservationById(Integer idReservation);
    public Reservation saveReservation(Reservation reservation);
    public Reservation editReservation(Reservation reservation);
    public void dropReservation(Integer idReservation);
    
}

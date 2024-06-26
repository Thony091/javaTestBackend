package com.duoc.usersRest.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer idUser;
  String nombre;
  String rut;
  String fechaNacimiento;
  String email;
  String telefono;
  String direccion;
  String contraseña;

}
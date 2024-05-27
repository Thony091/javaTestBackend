package com.duoc.usersRest.controladores;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.usersRest.modelo.Services;
import com.duoc.usersRest.servicio.Interfaces.IServicesService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("service-rest")
@CrossOrigin(value = "http://localhost:8080")
public class ServicesController {
  
  private static final Logger logger = (Logger) LoggerFactory.getLogger(RealizedWorkController.class);

  @Autowired
  private IServicesService serviceService;

  @GetMapping("/listar-servicios")
  public List<Services> listarServicios() {
    var services = serviceService.showServices();
    services.forEach( service  -> logger.info(service.toString())); 
    return services;
  }

  @GetMapping("/obtener-servicio/{id}")
  public Services obtenerServicio(@PathVariable Integer id) {
    var service = serviceService.searchServiceById(id);
    logger.info(service.toString());
    return service;
  }

  @PostMapping("/crear-servicio")
  public Services crearServicio(Services service) {
    var serviceCreated = serviceService.saveService(service);
    logger.info(serviceCreated.toString());
    return serviceCreated;
  }

  @PutMapping("/actualizar-servicio")
  public Services actualizarServicio(@RequestBody Services service) {
    var serviceUpdated = serviceService.editService(service);
    logger.info(serviceUpdated.toString());
    return serviceUpdated;
  }

  @DeleteMapping("/eliminar-servicio/{id}")
  public void eliminarServicio(@PathVariable Integer id) {
    serviceService.dropService(id);
  }

  
}

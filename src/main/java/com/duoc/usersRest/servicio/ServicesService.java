package com.duoc.usersRest.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.usersRest.modelo.Services;
import com.duoc.usersRest.repositorios.ServicesRepository;
import com.duoc.usersRest.servicio.Interfaces.IServicesService;

@Service
public class ServicesService implements IServicesService{

  @Autowired
  private ServicesRepository serviceRepository;
  
  @Override
  public List<Services> showServices() {
    return serviceRepository.findAll();
  }

  @Override
  public Services searchServiceById(Integer idService) {
    Services service = serviceRepository.findById(idService).orElse(null);
    return service;
  }

  @Override
  public Services saveService(Services service) {
    return serviceRepository.save(service);
  }

  @Override
  public Services editService(Services service) {
    Services serviceToEdit = serviceRepository.findById(service.getId()).orElse(null);
    serviceToEdit.setName(service.getName());
    serviceToEdit.setImages(service.getImages());
    serviceToEdit.setDescription(service.getDescription());
    serviceToEdit.setMinPrice(service.getMinPrice());
    serviceToEdit.setMaxPrice(service.getMaxPrice());
    serviceToEdit.setActive(false);
    return serviceRepository.save(service);
  }

  @Override
  public void dropService(Integer idService) {
    serviceRepository.deleteById(idService);
  }
  
}

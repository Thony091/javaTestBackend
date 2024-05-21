package com.duoc.usersRest.servicio.Interfaces;

import java.util.List;

import com.duoc.usersRest.modelo.Services;

public interface IServicesService {
    
    public List<Services> showServices();
    public Services searchServiceById(Integer idService);
    public Services saveService(Services service);
    public Services editService(Services service);
    public void dropService(Integer idService);
}

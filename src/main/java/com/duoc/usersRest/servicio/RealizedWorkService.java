package com.duoc.usersRest.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.usersRest.modelo.RealizedWork;
import com.duoc.usersRest.repositorios.RealizedWorkRepository;
import com.duoc.usersRest.servicio.Interfaces.IRealizedWorkService;

@Service
public class RealizedWorkService implements IRealizedWorkService{

  @Autowired
  private RealizedWorkRepository realizedWorkRepository;
  
  @Override
  public List<RealizedWork> showRealizedWorks() {
    return realizedWorkRepository.findAll();
  }

  @Override
  public RealizedWork searchRealizedWorkById(Integer idRealizedWork) {
    RealizedWork realizedWork = realizedWorkRepository.findById(idRealizedWork).orElse(null);
    return realizedWork;
  }

  @Override
  public RealizedWork saveRealizedWork(RealizedWork realizedWork) {
    return realizedWorkRepository.save(realizedWork);
  }

  @Override
  public RealizedWork editRealizedWork(RealizedWork realizedWork) {
    RealizedWork realizedWorkToEdit = realizedWorkRepository.findById(realizedWork.getId()).orElse(null);
    realizedWorkToEdit.setName(realizedWork.getName());
    realizedWorkToEdit.setImages(realizedWork.getImages());
    realizedWorkToEdit.setDescription(realizedWork.getDescription());
    return realizedWorkRepository.save(realizedWork);
  }

  @Override
  public void dropRealizedWork(Integer idRealizedWork) {
    realizedWorkRepository.deleteById(idRealizedWork);
  }
  
}

package com.duoc.usersRest.servicio.Interfaces;

import java.util.List;

import com.duoc.usersRest.modelo.RealizedWork;

public interface IRealizedWorkService {
  
  public List<RealizedWork> showRealizedWorks();
  public RealizedWork searchRealizedWorkById(Integer idRealizedWork);
  public RealizedWork saveRealizedWork(RealizedWork realizedWork);
  public RealizedWork editRealizedWork(RealizedWork realizedWork);
  public void dropRealizedWork(Integer idRealizedWork);
  
}

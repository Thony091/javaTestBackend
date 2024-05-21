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

import com.duoc.usersRest.modelo.RealizedWork;
import com.duoc.usersRest.servicio.Interfaces.IRealizedWorkService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("realized-work-rest")
@CrossOrigin(value = "http://localhost:8080")
public class RealizedWorkController {

  private static final Logger logger = (Logger) LoggerFactory.getLogger(RealizedWorkController.class);
  
  @Autowired
  private IRealizedWorkService realizedWorkService;

  @GetMapping("/listar-trabajos-realizados")
  public List<RealizedWork> listarTrabajosRealizados() {
    var realizedWorks = realizedWorkService.showRealizedWorks();
    realizedWorks.forEach( realizedWork  -> logger.info(realizedWork.toString())); 
    return realizedWorks;
  }
  
  @GetMapping("/obtener-trabajo-realizado/{id}")
  public RealizedWork obtenerTrabajoRealizado(@PathVariable Integer id) {
    var realizedWork = realizedWorkService.searchRealizedWorkById(id);
    logger.info(realizedWork.toString());
    return realizedWork;
  }

  @PostMapping("/crear-trabajo-realizado")
  public RealizedWork crearTrabajoRealizado(@RequestBody RealizedWork realizedWork) {
    var realizedWorkCreated = realizedWorkService.saveRealizedWork(realizedWork);
    logger.info(realizedWorkCreated.toString());
    return realizedWorkCreated;
  }

  @PutMapping("/actualizar-trabajo-realizado")
  public RealizedWork actualizarTrabajoRealizado(@RequestBody RealizedWork realizedWork) {
    var realizedWorkUpdated = realizedWorkService.editRealizedWork(realizedWork);
    logger.info(realizedWorkUpdated.toString());
    return realizedWorkUpdated;
  }

  @DeleteMapping("/eliminar-trabajo-realizado/{id}")
  public void eliminarTrabajoRealizado(@PathVariable Integer id) {
    realizedWorkService.dropRealizedWork(id);
    logger.info("Trabajo Realizado eliminado con éxito");
  }
}

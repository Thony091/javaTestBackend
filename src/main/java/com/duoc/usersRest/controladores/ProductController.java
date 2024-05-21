package com.duoc.usersRest.controladores;

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

import com.duoc.usersRest.modelo.Product;
import com.duoc.usersRest.servicio.Interfaces.IProductService;

import java.util.List;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("product-rest")
@CrossOrigin(value = "http://localhost:8080")
public class ProductController {
  
  private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioControlador.class);

  @Autowired
  private IProductService productService;

  @GetMapping("/listar-productos")
  public List<Product> listarProductos() {
    var products = productService.listarProductos();
    products.forEach( product  -> logger.info(product.toString())); 
    return products;
  }

  @GetMapping("/obtener-producto/{id}")
  public Product obtenerProducto(@PathVariable Integer id) {
    var product = productService.buscarProductoPorId(id);
    logger.info(product.toString());
    return product;
  }

  @PostMapping("/crear-producto")
  public Product crearProducto(@RequestBody Product product) {
    var productCreated = productService.guardarProducto(product);
    logger.info(productCreated.toString());
    return productCreated;
  }

  @PutMapping("/actualizar-producto")
  public Product actualizarProducto(@RequestBody Product product) {
    var productUpdated = productService.editarProducto(product);
    logger.info(productUpdated.toString());
    return productUpdated;
  }

  @DeleteMapping("/eliminar-producto/{id}")
  public void eliminarProducto(@PathVariable Integer id) {
    productService.eliminarProducto(id);
    logger.info("Producto eliminado con éxito");
  }

}
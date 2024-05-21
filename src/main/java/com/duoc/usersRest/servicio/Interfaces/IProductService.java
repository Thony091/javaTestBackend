package com.duoc.usersRest.servicio.Interfaces;

import java.util.List;

import com.duoc.usersRest.modelo.Product;


public interface IProductService {

  public List<Product> listarProductos();
  public Product buscarProductoPorId(Integer idProduct);
  public Product guardarProducto(Product product);
  public Product editarProducto(Product product);
  public void eliminarProducto(Integer idProduct);

}

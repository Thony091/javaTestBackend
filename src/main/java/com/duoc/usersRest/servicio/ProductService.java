package com.duoc.usersRest.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.usersRest.modelo.Product;
import com.duoc.usersRest.repositorios.ProductRepository;
import com.duoc.usersRest.servicio.Interfaces.IProductService;

@Service
public class ProductService implements IProductService{

  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Product> listarProductos() {
    return productRepository.findAll();
  }

  @Override
  public Product buscarProductoPorId(Integer idProduct) {
    Product product = productRepository.findById(idProduct).orElse(null);
    return product;
  }

  @Override
  public Product guardarProducto(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Product editarProducto(Product product) {
    Product productToEdit = productRepository.findById(product.getId()).orElse(null);
    productToEdit.setName(product.getName());
    productToEdit.setPrice(product.getPrice());
    productToEdit.setStock(product.getStock());
    return productRepository.save(productToEdit);
  }

  @Override
  public void eliminarProducto(Integer idProduct) {
    productRepository.deleteById(idProduct);
  }
  
}

package net.javaguides.springboot.springboothelloworldtutorial.service.impl;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProduct();
    public Product saveProduct(Product product);
    public Product deleteProductById(Integer id);
    public Product updateProduct(Product product);
    public List<Product> selectProductByCount();
}
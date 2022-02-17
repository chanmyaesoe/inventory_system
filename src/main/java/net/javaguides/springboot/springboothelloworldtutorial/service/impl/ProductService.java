package net.javaguides.springboot.springboothelloworldtutorial.service.impl;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Product;
import net.javaguides.springboot.springboothelloworldtutorial.entity.ProductDetail;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProduct(Integer pageNum, Integer pageSize);
    public Product saveProduct(Product product);
    public Product deleteProductById(Integer id);
    public Product updateProduct(Product product);
    public List<Product> selectProductByCount();
    public Product getCount();
}
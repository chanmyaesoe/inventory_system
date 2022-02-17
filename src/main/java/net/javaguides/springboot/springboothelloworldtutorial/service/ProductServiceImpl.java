package net.javaguides.springboot.springboothelloworldtutorial.service;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Product;
import net.javaguides.springboot.springboothelloworldtutorial.entity.ProductDetail;
import net.javaguides.springboot.springboothelloworldtutorial.mapper.ProductMapper;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAllProduct(Integer pageNum, Integer pageSize) {
        List<Product> list = productMapper.getAll(pageNum, pageSize);
        return list;
    }



    @Override
    public Product saveProduct(Product product) {
        productMapper.saveProduct(product);
        return product;
    }

    @Override
    public Product deleteProductById(Integer id) {
        productMapper.deleteProductById(id);
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        productMapper.updateProduct(product);
        return product;
    }

    @Override
    public List<Product> selectProductByCount() {
        List<Product> list = productMapper.selectByCount();
        return list;
    }

    @Override
    public Product getCount() {
        Product totalCount  = productMapper.getCount();
        return totalCount;
    }
}

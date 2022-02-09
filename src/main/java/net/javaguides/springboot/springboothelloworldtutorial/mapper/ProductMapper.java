package net.javaguides.springboot.springboothelloworldtutorial.mapper;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@Mapper
public interface ProductMapper {
    public List<Product> getAll();

    public void saveProduct(Product product);

    public void updateProduct(Long id, Product product);

    public void updateProduct(Product product);

    public void deleteProductById(@PathVariable("id") Integer id);

    public List<Product> selectByCount();
}

package net.javaguides.springboot.springboothelloworldtutorial.mapper;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Product;
import net.javaguides.springboot.springboothelloworldtutorial.entity.ProductDetail;
import net.javaguides.springboot.springboothelloworldtutorial.entity.ProductDetailParent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Mapper
public interface ProductDetailMapper {
    public List<ProductDetailParent> getAll(Integer pageNum, Integer pageSize);

    public void saveProductDetail(ProductDetail productDetail);

    public void updateProductDetail(Long id, ProductDetail productDetail);
    public void updateProduct(ProductDetail productDetail);

    public void updateProductDetail(ProductDetail productDetail);

    public void deleteProductDetailById(@PathVariable("id") Integer id);

    public List<ProductDetail> selectByCount();

    public ProductDetail getCount();
}

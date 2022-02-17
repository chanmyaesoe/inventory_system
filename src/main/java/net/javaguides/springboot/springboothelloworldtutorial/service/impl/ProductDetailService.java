package net.javaguides.springboot.springboothelloworldtutorial.service.impl;
import net.javaguides.springboot.springboothelloworldtutorial.entity.Employee;
import net.javaguides.springboot.springboothelloworldtutorial.entity.ProductDetail;
import net.javaguides.springboot.springboothelloworldtutorial.entity.ProductDetailParent;

import java.util.List;

public interface ProductDetailService {

    public List<ProductDetailParent> getAllProductDetail(Integer pageNum, Integer pageSize);
    public ProductDetail saveProductDetail(ProductDetail productDetail);
    public ProductDetail updateProduct(ProductDetail productDetail);
    public ProductDetail deleteProductDetailById(Integer id);
    public ProductDetail updateProductDetail(ProductDetail productDetail);
    public List<ProductDetail> selectProductDetailByCount();
    public ProductDetail getCount();
}

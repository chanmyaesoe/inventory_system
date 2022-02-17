package net.javaguides.springboot.springboothelloworldtutorial.service;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Calender;
import net.javaguides.springboot.springboothelloworldtutorial.entity.ProductDetail;
import net.javaguides.springboot.springboothelloworldtutorial.entity.ProductDetailParent;
import net.javaguides.springboot.springboothelloworldtutorial.mapper.ProductDetailMapper;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    public List<ProductDetailParent> getAllProductDetail(Integer pageNum, Integer pageSize) {
        List<ProductDetailParent> list = productDetailMapper.getAll(pageNum, pageSize);
        return list;
    }

    @Override
    public ProductDetail saveProductDetail(ProductDetail productDetail) {
        productDetailMapper.saveProductDetail(productDetail);
        return productDetail;
    }

    @Override
    public ProductDetail deleteProductDetailById(Integer id) {
        productDetailMapper.deleteProductDetailById(id);
        return null;
    }

    @Override
    public ProductDetail updateProductDetail(ProductDetail productDetail) {
        productDetailMapper.updateProductDetail(productDetail);
        return productDetail;
    }

    @Override
    public ProductDetail updateProduct(ProductDetail productDetail) {
        productDetailMapper.updateProduct(productDetail);
        return productDetail;
    }

    @Override
    public List<ProductDetail> selectProductDetailByCount() {
        List<ProductDetail> list = productDetailMapper.selectByCount();
        return list;
    }

    @Override
    public ProductDetail getCount() {
        ProductDetail totalCount  = productDetailMapper.getCount();
        return totalCount;
    }
}

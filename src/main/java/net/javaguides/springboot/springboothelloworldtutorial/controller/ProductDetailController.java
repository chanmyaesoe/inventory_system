package net.javaguides.springboot.springboothelloworldtutorial.controller;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Employee;
import net.javaguides.springboot.springboothelloworldtutorial.entity.Product;
import net.javaguides.springboot.springboothelloworldtutorial.entity.ProductDetail;
import net.javaguides.springboot.springboothelloworldtutorial.entity.ProductDetailParent;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@RestController
@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class ProductDetailController {

    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("/product-details")
    public ResponseEntity<Object> getAllProductDetail(@RequestParam(defaultValue  = "0") Integer pageNum ,@RequestParam(defaultValue  = "0") Integer pageSize) { //get all data
        List<ProductDetailParent> list = productDetailService.getAllProductDetail(((pageNum -1) * pageSize), pageSize);
        ProductDetail count = productDetailService.getCount();
        Map<String, Long> pageInfo = new HashMap<String, Long>();
        pageInfo.put("pageSize", count.getId());
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, list, pageInfo);
    }

    @PostMapping("/product-details")
    public ResponseEntity<Object> saveProduct(ProductDetail productDetail) { // create data
        try {
            ProductDetail _productDetail = productDetailService.saveProductDetail(productDetail);
            ProductDetail _product = productDetailService.updateProduct(productDetail);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/product-details/{id}")
    public ResponseEntity<Object> updateProduct(ProductDetail productDetail) { // update data
        try {
            ProductDetail _productDetail = productDetailService.updateProductDetail(productDetail);
            return ResponseHandler.generateResponse("Successfully update data!", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/product-details/{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable("id") int id) { // delete data
        try {
            ProductDetail _productDetail = productDetailService.deleteProductDetailById(id);
            return ResponseHandler.generateResponse("Successfully delete data!", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/product-details/export")
    public void exportToCSV(HttpServletResponse response) throws IOException { // export data
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=products_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<ProductDetailParent> listUsers = productDetailService.getAllProductDetail(0,10);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"item Name", "Item Count", "Stocked At", "Updated At"};
        String[] nameMapping = {"product_name","current_count","stocked_at","updated_at"};

        csvWriter.writeHeader(csvHeader);

        for (ProductDetail productDetail : listUsers) {
            csvWriter.write(productDetail, nameMapping);
        }
        csvWriter.close();
    }

//    @GetMapping("/productsCount")
//    public List<ProductDetail> reportCurrentTime() {
//        List<ProductDetail> list = productDetailService.getAllProductDetail();
//        return list;
//    }

}

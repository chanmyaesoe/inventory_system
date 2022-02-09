package net.javaguides.springboot.springboothelloworldtutorial.controller;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Product;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.ProductService;
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
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProduct() { //get all data
        List<Product> list = productService.getAllProduct();
        return list;
    }

    @PostMapping("/products")
    public ResponseEntity<Object> saveProduct(Product product) { // create data
        try {
            Product _tutorial = productService.saveProduct(product);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(Product product) { // update data
        try {
            Product _product = productService.updateProduct(product);
            return ResponseHandler.generateResponse("Successfully update data!", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable("id") int id) { // delete data
        try {
            Product _product = productService.deleteProductById(id);
            return ResponseHandler.generateResponse("Successfully delete data!", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/products/export")
    public void exportToCSV(HttpServletResponse response) throws IOException { // export data
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=products_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Product> listUsers = productService.getAllProduct();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"item Name", "Item Count", "Stocked At", "Updated At"};
        String[] nameMapping = {"product_name","current_count","stocked_at","updated_at"};

        csvWriter.writeHeader(csvHeader);

        for (Product product : listUsers) {
            csvWriter.write(product, nameMapping);
        }
        csvWriter.close();
    }

//    @GetMapping("/productsCount")
//    public List<Product> reportCurrentTime() {
//        List<Product> list = productService.getAllProduct();
//        return list;
//    }

}

package net.javaguides.springboot.springboothelloworldtutorial.controller;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Inventory;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.InventoryService;
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
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventories")
    public List<Inventory> getAllInventory() { //get all data
        List<Inventory> list = inventoryService.getAllInventory();
        return list;
    }

    @PostMapping("/inventories")
    public ResponseEntity<Object> saveInventory(Inventory inventory) { // create data
        try {
            Inventory _tutorial = inventoryService.saveInventory(inventory);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/inventories/{id}")
    public ResponseEntity<Object> updateInventory(Inventory inventory) { // update data
        try {
            Inventory _inventory = inventoryService.updateInventory(inventory);
            return ResponseHandler.generateResponse("Successfully update data!", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/inventories/{id}")
    public ResponseEntity<Object> deleteInventoryById(@PathVariable("id") int id) { // delete data
        try {
            Inventory _inventory = inventoryService.deleteInventoryById(id);
            return ResponseHandler.generateResponse("Successfully delete data!", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/inventories/export")
    public void exportToCSV(HttpServletResponse response) throws IOException { // export data
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=inventories_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Inventory> listUsers = inventoryService.getAllInventory();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"item Name", "Item Count", "Stocked At", "Updated At"};
        String[] nameMapping = {"item_name","item_count","stocked_at","updated_at"};

        csvWriter.writeHeader(csvHeader);

        for (Inventory inventory : listUsers) {
            csvWriter.write(inventory, nameMapping);
        }
        csvWriter.close();
    }

}

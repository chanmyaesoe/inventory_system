package net.javaguides.springboot.springboothelloworldtutorial.controller;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Item;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> getAllItem() {
        List<Item> list = itemService.getAllItem();
        return list;
    }

//    @RequestMapping("/saveItem")
//    public void saveItem(Item item) {
//        itemService.saveItem(item);
//    }
//
//    @RequestMapping("/deleteItemById")
//    public void deleteItemById(Long id) {
//        itemService.deleteItemById(id);
//    }
//
//    @RequestMapping("/updateItem")
//    public void updateItem(Long id, String name, String  passWord) {
//        itemService.updateItem(id, name, passWord);
//    }
}

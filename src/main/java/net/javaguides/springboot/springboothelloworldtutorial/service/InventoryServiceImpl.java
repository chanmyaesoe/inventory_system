package net.javaguides.springboot.springboothelloworldtutorial.service;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Inventory;
import net.javaguides.springboot.springboothelloworldtutorial.mapper.InventoryMapper;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public List<Inventory> getAllInventory() {
        List<Inventory> list = inventoryMapper.getAll();
        return list;
    }

    @Override
    public Inventory saveInventory(Inventory inventory) {
        inventoryMapper.saveInventory(inventory);
        return inventory;
    }

    @Override
    public Inventory deleteInventoryById(Integer id) {
        inventoryMapper.deleteInventoryById(id);
        return null;
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        inventoryMapper.updateInventory(inventory);
        return inventory;
    }
}

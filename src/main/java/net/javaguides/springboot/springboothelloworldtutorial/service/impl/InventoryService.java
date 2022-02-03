package net.javaguides.springboot.springboothelloworldtutorial.service.impl;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Inventory;

import java.util.List;

public interface InventoryService {

    public List<Inventory> getAllInventory();
    public Inventory saveInventory(Inventory inventory);
    public Inventory deleteInventoryById(Integer id);
//    public void updateInventory(Integer id, Inventory inventory);

    public Inventory updateInventory(Inventory inventory);
}
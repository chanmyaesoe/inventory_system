package net.javaguides.springboot.springboothelloworldtutorial.mapper;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface InventoryMapper {
    public List<Inventory> getAll();

    public void saveInventory(Inventory inventory);

    public void updateInventory(Long id, Inventory inventory);

    public void updateInventory(Inventory inventory);

    public void deleteInventoryById(@PathVariable("id") Integer id);
//    public void saveInventory(Inventory inventory);
//    public void deleteInventoryById(Long id);
//    public void updateInventory(@Param("id") Long id, @Param("inventoryName") String inventoryName,
//                           @Param("password") String passWord);
}

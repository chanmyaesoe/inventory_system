package net.javaguides.springboot.springboothelloworldtutorial.mapper;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {
    public List<Item> getAll();
//    public void saveItem(Item item);
//    public void deleteItemById(Long id);
//    public void updateItem(@Param("id") Long id, @Param("name") String name,
//                           @Param("password") String passWord);
}
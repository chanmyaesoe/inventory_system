package net.javaguides.springboot.springboothelloworldtutorial.service;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Item;
import net.javaguides.springboot.springboothelloworldtutorial.mapper.ItemMapper;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> getAllItem() {
        List<Item> list = itemMapper.getAll();
        return list;
    }

//    @Override
//    public void saveItem(Item item) {
//        itemMapper.saveItem(item);
//    }
//
//    @Override
//    public void deleteItemById(Long id) {
//        itemMapper.deleteItemById(id);
//    }
//
//    @Override
//    public void updateItem(Long id, String name, String  passWord) {
//        itemMapper.updateItem(id, name, passWord);
//    }
}

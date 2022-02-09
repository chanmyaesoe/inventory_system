package net.javaguides.springboot.springboothelloworldtutorial.service;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Calender;
import net.javaguides.springboot.springboothelloworldtutorial.entity.CalenderEmployee;
import net.javaguides.springboot.springboothelloworldtutorial.entity.Product;
import net.javaguides.springboot.springboothelloworldtutorial.mapper.CalenderMapper;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.CalenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CalenderServiceImpl implements CalenderService {

    @Autowired
    private CalenderMapper calenderMapper;

    @Override
    public List<CalenderEmployee> getAllCalender() {
        List<CalenderEmployee> list = calenderMapper.selectCalender();
        return list;
    }
    @Override
    public  List<CalenderEmployee> getCalenderByDate(Timestamp date, Timestamp to) {
        List<CalenderEmployee> list = calenderMapper.selectCalenderByDate(date, to);
        return list;
    }

    @Override
    public Calender saveCalender(Calender calender) {
        calenderMapper.saveCalender(calender);
        return null;
    }
    @Override
    public Product updateCount(Long product_id, Integer count) {
        calenderMapper.updateCount(product_id, count);
        return null;
    }

    @Override
    public Calender deleteCalenderById(Long id) {
        calenderMapper.deleteCalenderById(id);
        return null;
    }

    @Override
    public Calender updateCalender(Calender calender) {
        calenderMapper.updateCalender(calender);
        return null;
    }
}

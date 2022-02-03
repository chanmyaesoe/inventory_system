package net.javaguides.springboot.springboothelloworldtutorial.service;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Calender;
import net.javaguides.springboot.springboothelloworldtutorial.entity.CalenderEmployee;
import net.javaguides.springboot.springboothelloworldtutorial.entity.Inventory;
import net.javaguides.springboot.springboothelloworldtutorial.mapper.CalenderMapper;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.CalenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Inventory saveCalender(Calender calender) {
        calenderMapper.saveCalender(calender);
        return null;
    }

    @Override
    public Inventory deleteCalenderById(Long id) {
        calenderMapper.deleteCalenderById(id);
        return null;
    }

    @Override
    public Inventory updateCalender(Calender calender) {
        calenderMapper.updateCalender(calender);
        return null;
    }
}

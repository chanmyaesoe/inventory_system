package net.javaguides.springboot.springboothelloworldtutorial.service.impl;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Calender;
import net.javaguides.springboot.springboothelloworldtutorial.entity.CalenderEmployee;
import net.javaguides.springboot.springboothelloworldtutorial.entity.Product;

import java.sql.Timestamp;
import java.util.List;

public interface CalenderService {

    public List<CalenderEmployee> getAllCalender();
    public Calender saveCalender(Calender calender);
    public Calender deleteCalenderById(Long id);
    public Calender updateCalender(Calender calender);
    public List<CalenderEmployee> getCalenderByDate(Timestamp date,Timestamp to);
    public Product updateCount(Long product_id, Integer count);

}
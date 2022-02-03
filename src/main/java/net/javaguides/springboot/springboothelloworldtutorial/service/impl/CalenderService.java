package net.javaguides.springboot.springboothelloworldtutorial.service.impl;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Calender;
import net.javaguides.springboot.springboothelloworldtutorial.entity.CalenderEmployee;
import net.javaguides.springboot.springboothelloworldtutorial.entity.Inventory;

import java.util.List;

public interface CalenderService {

    public List<CalenderEmployee> getAllCalender();
    public Inventory saveCalender(Calender calender);
    public Inventory deleteCalenderById(Long id);
    public Inventory updateCalender(Calender calender);

}
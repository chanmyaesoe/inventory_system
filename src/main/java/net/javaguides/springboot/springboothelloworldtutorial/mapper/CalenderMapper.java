package net.javaguides.springboot.springboothelloworldtutorial.mapper;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Calender;
import net.javaguides.springboot.springboothelloworldtutorial.entity.CalenderEmployee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CalenderMapper {
    public List<CalenderEmployee> selectCalender();

    public void saveCalender(Calender calender);

    public void updateCalender(Calender calender);

    public void deleteCalenderById(Long id);
}

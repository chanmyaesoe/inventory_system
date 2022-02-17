package net.javaguides.springboot.springboothelloworldtutorial.mapper;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Calender;
import net.javaguides.springboot.springboothelloworldtutorial.entity.CalenderEmployee;
import net.javaguides.springboot.springboothelloworldtutorial.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface CalenderMapper {
    public List<CalenderEmployee> getAll(Integer pageNum, Integer pageSize);

    public void saveCalender(Calender calender);

    public void updateCalender(Calender calender);

    public void deleteCalenderById(Long id);

    public List<CalenderEmployee> selectCalenderByDate(Timestamp date, Timestamp to);

    public  void  updateCount(Long product_id, Integer count);

    public Calender getCount();

}

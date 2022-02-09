package net.javaguides.springboot.springboothelloworldtutorial.entity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalenderEmployee extends Calender {

    private String first_name;
    private String last_name;
    private String product_name;
    private Integer current_count;
}

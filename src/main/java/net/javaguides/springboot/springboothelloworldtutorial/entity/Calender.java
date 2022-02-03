package net.javaguides.springboot.springboothelloworldtutorial.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "calenders")
public class Calender implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(nullable = false)
//    private Integer employee_id;

    @Column(nullable = false)
    private Integer count;

//
//    private Employee employee;
    private Long employee_id;//The id of the employee corresponding to the calender
//    private Employee employee;

//    private Long inventory_id;
//    private Inventory inventory;

    private Long inventory_id;
//    private Inventory inventory;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp datetime;

}

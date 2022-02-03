package net.javaguides.springboot.springboothelloworldtutorial.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inventories")
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String item_name;

    private Integer item_count;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp stocked_at;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updated_at;

}

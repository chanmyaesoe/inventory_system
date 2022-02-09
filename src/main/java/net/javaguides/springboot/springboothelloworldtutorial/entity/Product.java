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
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String product_name;
    private String barcode;

    @Column(nullable = true)
    private Integer current_count;
    @Column(nullable = true)
    private Float price;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Manila")
    @Column(nullable = true)
    private Timestamp last_stocked_at;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Manila")
    private Timestamp created_at;
    // List<Player> mPlayers;
    @OneToMany
    private List<ProductDetail> productDetails;

}

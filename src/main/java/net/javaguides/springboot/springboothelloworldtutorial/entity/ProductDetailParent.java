package net.javaguides.springboot.springboothelloworldtutorial.entity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailParent extends ProductDetail{
    private String product_name;
}

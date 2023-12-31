package com.example.exam_java.dto;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private int id;
    private int categoryId;
    private String name;
    private int price;
    private int quantity;
}

package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class SalesItem {

    private Long id;

    private Integer num;
    private Product product;
    private Integer count;

}

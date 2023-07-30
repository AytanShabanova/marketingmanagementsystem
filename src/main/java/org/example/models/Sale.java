package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    private Long id;
    private Integer num;
    private BigDecimal total;
    List<SalesItem>salesItems;
    LocalDateTime localDateTime;

}

package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    private Long id;
    private Integer num;
    private BigDecimal total;
    private List<SalesItem> salesItems;
    private LocalDateTime localDateTime;

}

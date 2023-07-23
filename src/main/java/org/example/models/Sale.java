package org.example.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Sale {
    private Long id;
    private Integer num;
    private BigDecimal total;
    List<SalesItem>salesItems;
    LocalDateTime localDateTime;

}

package org.example.service.inter;

import org.example.models.Sale;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface SaleInter {
      void addNewSale(Sale sale);
      void returnProduct(Integer saleNum,String productBarCode,Integer count);
      void removeSale(Integer saleNum);
      void getAllSales();
   List<Sale> saleByPrice(BigDecimal min,BigDecimal max);
   void getSalesByDate(LocalDateTime localDateTime);
  Sale getSaleByNum(Integer num);

}

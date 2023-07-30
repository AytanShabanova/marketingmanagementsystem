package org.example.service.impl;

import org.example.models.Sale;
import org.example.models.SalesItem;
import org.example.service.inter.SaleInter;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleImpl implements SaleInter {
    public   static    List<Sale>sales=new ArrayList<>();

    @Override
    public void addNewSale(Sale sale) {
        sales.add(sale);
        System.out.println(sale);
    }

    @Override
    public void returnProduct(Integer saleNum, String productBarCode, Integer count) {
       Sale sale1= sales.stream().filter(sale -> sale.getNum().equals(saleNum)).findFirst().get();
  SalesItem salesItem1= sale1.getSalesItems().stream().filter(salesItem -> salesItem.getProduct().getBarCode().equals(productBarCode)).findFirst().get();
    salesItem1.getProduct().setCount(count);
    sale1.getSalesItems().remove(salesItem1);

    }

    @Override
    public void removeSale(Integer saleNum) {
      Sale sale1=  sales.stream().filter(sale -> sale.getNum().equals(saleNum)).findFirst().get();
      sales.remove(sale1);
    }

    @Override
    public void getAllSales() {
        sales.stream().forEach(sale -> System.out.println(sale));
    }

    @Override
    public List<Sale> saleByPrice(BigDecimal min, BigDecimal max) {
        List<Sale>sales1=sales.stream().toList();
  sales1.stream().forEach(sale -> sale.getTotal().min(min).max(max));

        System.out.println(sales1);
           return sales1;
    }

    @Override
    public void getSalesByDate(LocalDateTime localDateTime) {
      Sale sale1=  sales.stream().filter(sale -> sale.getLocalDateTime().equals(localDateTime)).findFirst().get();
        System.out.println(sale1);
    }

    @Override
    public Sale getSaleByNum(Integer num) {
      Sale sale1=  sales.stream().filter(sale -> sale.getNum().equals(num)).findFirst().get();
        System.out.println(sale1);
        return sale1;
    }




}

package org.example.service.impl;

import org.example.models.Sale;
import org.example.models.SalesItem;
import org.example.service.inter.SaleInter;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleImpl implements SaleInter {
    public static List<Sale> sales = new ArrayList<>();

    @Override
    public void addNewSale(Sale sale) {
        sales.add(sale);

    }

    @Override
    public void returnProduct(Integer saleNum, String productBarCode, Integer count) {
        Sale sale1 = sales.stream().filter(sale -> sale.getNum().equals(saleNum)).findFirst().get();
        SalesItem salesItem1 = sale1.getSalesItems()
                .stream().filter(salesItem -> salesItem.getProduct().getBarCode().equals(productBarCode)).findFirst().get();
        salesItem1.getProduct().setCount(salesItem1.getProduct().getCount()+count);
        if (salesItem1.getCount()==count){
        sale1.getSalesItems().remove(salesItem1);
        } else {
            sale1.getSalesItems().remove(salesItem1);
            salesItem1.setCount(salesItem1.getCount()-count);
            sale1.getSalesItems().add(salesItem1);

        }

    }

    @Override
    public void removeSale(Integer saleNum) {
        Sale sale1 = sales.stream().filter(sale -> sale.getNum().equals(saleNum)).findFirst().get();
        sales.remove(sale1);
    }

    @Override
    public List<Sale> getAllSales() {
      List<Sale>saleList=  sales.stream().toList();
      return saleList;
    }

    @Override
    public List<Sale> saleByPrice(BigDecimal min, BigDecimal max) {
    List<Sale>saleList= sales.stream().filter(sale -> 1==sale.getTotal().compareTo(min) && sale.getTotal().compareTo(max)==-1).toList();
       return saleList;
    }

    @Override
    public Sale getSalesByDate(LocalDateTime localDateTime) {
        Sale sale1 = sales.stream().filter(sale -> sale.getLocalDateTime().equals(localDateTime)).findFirst().get();
       return sale1;
    }

    @Override
    public Sale getSaleByNum(Integer num) {
        Sale sale1 = sales.stream().filter(sale -> sale.getNum().equals(num)).findFirst().get();

        return sale1;
    }


}

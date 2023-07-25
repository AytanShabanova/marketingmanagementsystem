package org.example.service.impl;

import org.example.models.Catagory;
import org.example.models.Product;
import org.example.service.inter.ProductInter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements ProductInter {
    List<Product>products=new ArrayList<>();
    @Override
    public void addProduct(Product product) {
      products.add(product);
    }

    @Override
    public BigDecimal updateProductByPrice(String barCode, BigDecimal price) {
      Product product1= products.stream().filter(product -> product.getBarCode().equals(barCode)).findFirst().get();
   product1.setPrice(price);
      return   product1.getPrice() ;
    }

    @Override
    public  Integer updateProductByCount(String barCode,Integer count) {
     Product product1= products.stream().filter(product -> product.getBarCode().equals(barCode)).findFirst().get();
     product1.setCount(count);
     return product1.getCount();
    }

    @Override
    public void removeProduct(String barCode) {
        products.remove(barCode);

    }

    @Override
    public void getProduct(List<Product> productss) {
      products.stream().forEach(product -> System.out.println(productss));

    }

    @Override
    public void getCatagoryProduct(String catagory) {
  products.stream().filter(product -> product.getCatagory().equals(catagory)).forEach(product -> System.out.println(products));

    }

    @Override
    public void getProductByPrice() {

    }
}

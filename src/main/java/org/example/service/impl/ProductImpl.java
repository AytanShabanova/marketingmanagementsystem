package org.example.service.impl;

import org.example.models.Product;
import org.example.service.inter.ProductInter;

import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements ProductInter {
    List<Product>products=new ArrayList<>();
    @Override
    public void addProduct(Product product) {
      products.add(product);
    }

    @Override
    public void updateProduct(String code) {
           products.stream().filter(product -> product.getBarCode().equals(code)).findFirst().get();
    }

    @Override
    public void removeProduct(String code) {

    }

    @Override
    public void getProduct(List<Product> products) {

    }

    @Override
    public void getCatagoryProduct(String catagory, List<Product> product) {

    }
}

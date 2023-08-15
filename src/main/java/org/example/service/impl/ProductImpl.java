package org.example.service.impl;

import org.example.models.Catagory;
import org.example.models.Product;
import org.example.service.inter.ProductInter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductImpl implements ProductInter {
    public static List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public Product updateProductByPrice(String barCode, BigDecimal price) {
        Product product1 = products.stream().filter(product -> product.getBarCode().equals(barCode)).findFirst().get();
        product1.setPrice(price);

        return product1;
    }

    @Override
    public Product updateProductByCount(String barCode, Integer count) {
        Product product1 = products.stream().filter(product -> product.getBarCode().equals(barCode)).findFirst().get();
        product1.setCount(count);

        return product1;
    }

    @Override
    public void removeProduct(String barCode) {
        Product product1 = products.stream().filter(product -> product.getBarCode().equals(barCode)).findFirst().get();
        products.remove(product1);


    }

    @Override
    public List<Product> getAllProduct() {
      List<Product>productList= products.stream().toList();
        return productList;

    }

    @Override
    public List<Product>getProductByCatagory(Catagory catagory) {
       List<Product>productList= products.stream().filter(product -> product.getCatagory().equals(catagory)).toList();
       return productList;

    }

    @Override
    public List<Product> getProductByPrice( Double min, Double max) {
//        ProductImpl productimpl = new ProductImpl();
//        if (!(productimpl.getProductByBarCode(barCode) == null)) {
//            for (Product product : products) {
//                if (product.getPrice().doubleValue() > min && product.getPrice().doubleValue() < max) {
//                    System.out.println(product);
//                }
//            }
//        }
       List<Product>productList= products.stream()
               .filter(product -> product.getPrice().doubleValue()>min && product.getPrice().doubleValue()<max).toList();
       return productList;
    }

    @Override
    public Product getProductByBarCode(String barCode) {
        Product product1 = products.stream().filter(product -> product.getBarCode().equals(barCode)).findFirst().get();
        return product1;
    }

    @Override
    public Product searchProductByName(String name) {

Product product1= products.stream().filter(product -> product.getName().equals(name)).findFirst().orElseThrow(() -> new NoSuchElementException("bu adda mehsul yoxdur"));
   return product1;
    }

}

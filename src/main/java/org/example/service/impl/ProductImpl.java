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
    public Integer updateProductByPrice(String barCode, Integer price) {
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
    public List<Product> getProduct() {
     List<Product>productList=products;
     productList.stream().forEach(product -> System.out.println(product));
     return productList;

    }

    @Override
    public void getCatagoryProduct(String catagory) {
  products.stream().filter(product -> product.getCatagory().equals(catagory)).forEach(product -> System.out.println(products));

    }

    @Override
    public void getProductByPrice(String barCode ,Integer min,Integer max) {
        ProductImpl productimpl=new ProductImpl();
        if (!(productimpl.getProductByBarCode(barCode) ==null)) {
            for (Product product : products) {
                if (product.getPrice() > min && product.getPrice() < max) {
                    System.out.println(product);
                }
            }
        }
    }

    @Override
    public Product getProductByBarCode(String barCode) {
     Product product1=  products.stream().filter(product -> product.getBarCode().equals(barCode)).findFirst().get();
     return product1;
    }

    @Override
    public void searchProductByName(String name) {

      products.stream().filter(product -> product.getName().equals(name)).forEach(product -> System.out.println(product));
    }

}

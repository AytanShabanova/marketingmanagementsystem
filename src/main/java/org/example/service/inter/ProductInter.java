package org.example.service.inter;

import org.example.models.Catagory;
import org.example.models.Product;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

public interface ProductInter {
    void  addProduct(Product product);
    Product updateProductByPrice(String barCode,BigDecimal price);
   Product updateProductByCount(String barCode,Integer count);
    void  removeProduct(String barCode);
    List<Product> getAllProduct();
    void getProductByCatagory(Catagory catagory );
    List<Product> getProductByPrice(Double min,Double max);
    Product getProductByBarCode(String barCode);
    Product searchProductByName(String name);


}

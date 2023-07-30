package org.example.service.inter;

import org.example.models.Catagory;
import org.example.models.Product;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

public interface ProductInter {
    void  addProduct(Product product);
    BigDecimal updateProductByPrice(String barCode,BigDecimal price);
    Integer updateProductByCount(String barCode,Integer count);
    void  removeProduct(String barCode);
    List<Product> getAllProduct();
    void getProductByCatagory(Catagory catagory );
    void getProductByPrice(String barCode ,Integer min,Integer max);
    Product getProductByBarCode(String barCode);
    void searchProductByName(String name);


}

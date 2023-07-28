package org.example.service.inter;

import org.example.models.Product;

import java.awt.*;
import java.util.List;

public interface ProductInter {
    void  addProduct(Product product);
    Double updateProductByPrice(String barCode, Double price);
    Integer updateProductByCount(String barCode,Integer count);
    void  removeProduct(String barCode);
    List<Product> getProduct();
    void getCatagoryProduct(String catagory );
    void getProductByPrice(String barCode ,Integer min,Integer max);
    Product getProductByBarCode(String barCode);
    void searchProductByName(String name);


}

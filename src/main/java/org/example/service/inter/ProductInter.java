package org.example.service.inter;

import org.example.models.Product;

import java.util.List;

public interface ProductInter {
    void  addProduct(Product product);
    Integer updateProductByPrice(String barCode, Integer price);
    Integer updateProductByCount(String barCode,Integer count);
    void  removeProduct(String barCode);
    void getProduct(List<Product> products);
    void getCatagoryProduct(String catagory );
    void getProductByPrice(String barCode ,Integer min,Integer max);
    Product getProductByBarCode(String barCode);

}

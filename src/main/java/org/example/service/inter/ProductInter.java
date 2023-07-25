package org.example.service.inter;

import org.example.models.Product;

import java.util.List;

public interface ProductInter {
    void  addProduct(Product product);
    void updateProduct(String code);
    void  removeProduct(String code);
    void getProduct(List<Product> products);
    void getCatagoryProduct(String catagory ,List<Product>product);

}

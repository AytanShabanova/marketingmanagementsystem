package org.example.service.inter;

import org.example.models.Catagory;
import org.example.models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductInter {
    void  addProduct(Product product);
    BigDecimal updateProductByPrice(String barCode, BigDecimal price);
    Integer updateProductByCount(String barCode,Integer count);
    void  removeProduct(String code);
    void getProduct(List<Product> products);
    void getCatagoryProduct(String catagory );
    void getProductByPrice();

}

package org.example.service.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.config.AbstractDao;
import org.example.models.Catagory;
import org.example.models.Product;
import org.example.service.inter.ProductInter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductDbImpl  extends AbstractDao implements ProductInter {
    @Override
    public void addProduct(Product product) {
        EntityManager entityManager=em();
        entityManager.getTransaction().begin();
  entityManager.persist(product);
  entityManager.getTransaction().commit();
  entityManager.close();
    }

    @Override
    public Product updateProductByPrice(String barCode, BigDecimal price) {
       EntityManager entityManager=em();
       entityManager.getTransaction().begin();
       Product product=getProductByBarCode(barCode);
       product.setPrice(price);
       entityManager.merge(product);
       entityManager.getTransaction().commit();
       entityManager.close();
       return product;


    }

    @Override
    public Product updateProductByCount(String barCode, Integer count) {
        EntityManager entityManager=em();
        entityManager.getTransaction().begin();
        Product product=getProductByBarCode(barCode);
        product.setCount(count);
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        entityManager.close();
        return product;
    }

    @Override
    public void removeProduct(String barCode) {
          EntityManager entityManager=em();
          entityManager.getTransaction().begin();
          Product product=getProductByBarCode(barCode);
          entityManager.remove(entityManager.merge(product));
          entityManager.getTransaction().commit();
          entityManager.close();
    }

    @Override
    public List<Product> getAllProduct() {
        EntityManager entityManager=em();
        entityManager.getTransaction().begin();
     TypedQuery<Product>typedQuery =entityManager.createQuery("select t from Product t ",Product.class);
      List<Product>products=typedQuery.getResultList();
     entityManager.getTransaction().commit();
     entityManager.close();
     return products;
    }

    @Override
    public List<Product> getProductByCatagory(Catagory catagory) {
        EntityManager entityManager=em();
        entityManager.getTransaction().begin();
       TypedQuery<Product>typedQuery= entityManager.createQuery("select t from Product t where t.catagory=?1",Product.class);
       typedQuery.setParameter(1,catagory);


        List<Product>products=typedQuery.getResultList();
        return products;

    }

    @Override
    public List<Product> getProductByPrice(Double min, Double max) {
   EntityManager entityManager=em();
   entityManager.getTransaction().begin();
   TypedQuery<Product>typedQuery=entityManager.createQuery("select t from Product t where t.price between : min and :max",Product.class);
   typedQuery.setParameter("min",min);
   typedQuery.setParameter("max",max);
   List<Product>productList= typedQuery.getResultList();


        return productList;
    }

    @Override
    public Product getProductByBarCode(String barCode) {
        EntityManager entityManager=em();
        entityManager.getTransaction().begin();
       TypedQuery<Product>typedQuery= entityManager.createQuery("select t from Product t where t.barCode=?1",Product.class);
        typedQuery.setParameter(1,barCode);
  Product product= typedQuery.getSingleResult();
  return product;


    }

    @Override
    public Product searchProductByName(String name) {
        EntityManager entityManager=em();
        entityManager.getTransaction().begin();
      TypedQuery<Product>typedQuery=  entityManager.createQuery("select t from Product t where t.name=?1",Product.class);
        typedQuery.setParameter(1,name);
       Product product= typedQuery.getSingleResult();
        return product;
    }
}

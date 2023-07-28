package org.example.operations;

import org.example.models.Catagory;
import org.example.models.Product;
import org.example.service.impl.ProductImpl;

import java.util.Scanner;

public class ProductOperation {
    static long id=0;
    static ProductImpl productImpl=new ProductImpl();
    static Scanner sc=new Scanner(System.in);


   public void addProductOperation(){
       System.out.println("ENTER PRODUCT NAME");
       String name=sc.next();
       System.out.println("ENTER PRODUCT PRICE");
      Double price= sc.nextDouble();
       System.out.println("ENTER COUNT");
       int count= sc.nextInt();
       System.out.println("Enter barcode");
       String barCode= sc.next();
       System.out.println("ENTER PRODUCT CATEGORY\n " +
               "1.MEAT_PRODUCTS \n" +
               "2.DRINK" +
               "3.BEVERAGE_PRODUCTS" +
               "4.FLOUR_PRODUCTS" +
               "5.SEAFOOD");
       int countctg=sc.nextInt();
       if (countctg==1){
           Product product=new Product(id++,name,price,Catagory.MEAT_PRODUCTS,count,barCode);
           productImpl.addProduct(product);
           System.out.println(product);

       } else if (countctg==2) {
           Product product=new Product(id++,name,price,Catagory.DRINK,count,barCode);
           productImpl.addProduct(product);
           System.out.println(product);

       } else if (countctg==3) {
           Product product=new Product(id++,name,price,Catagory.BEVERAGE_PRODUCTS,count,barCode);
           productImpl.addProduct(product);
           System.out.println(product);

       } else if (countctg==4) {
           Product product=new Product(id++,name,price,Catagory.FLOUR_PRODUCTS,count,barCode);
           productImpl.addProduct(product);
           System.out.println(product);

       } else if (countctg==5) {
           Product product=new Product(id++,name,price,Catagory.SEAFOOD,count,barCode);
           productImpl.addProduct(product);
           System.out.println(product);


       }


   }

}

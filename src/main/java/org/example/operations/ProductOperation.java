package org.example.operations;

import org.example.models.Catagory;
import org.example.models.Product;
import org.example.service.impl.ProductImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ProductOperation {
    static long id=0;
    static ProductImpl productImpl=new ProductImpl();
    static Scanner sc=new Scanner(System.in);


   public void addProductOp(){
       System.out.println("ENTER PRODUCT NAME");
       String name=sc.next();
       System.out.println("ENTER PRODUCT PRICE");
      BigDecimal price= sc.nextBigDecimal();
       System.out.println("ENTER COUNT");
       int count= sc.nextInt();
       System.out.println("Enter barcode");
       String barCode= sc.next();
       System.out.println("  ENTER PRODUCT CATEGORY\n " +
               "1.MEAT_PRODUCTS \n" +
               "2.DRINK \n" +
               "3.BEVERAGE_PRODUCTS \n" +
               "4.FLOUR_PRODUCTS \n" +
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
   public void updateProductByPriceOperation(){
       System.out.println("ENTER PRODUCT BARCODE");
       String barCode= sc.next();
       System.out.println("ENTER NEW PRICE");
      BigDecimal price=sc.nextBigDecimal();
      Product product= productImpl.updateProductByPrice(barCode,price);
       System.out.println(product);
   }
   public void updateProductByCountOperation(){
       System.out.println("ENTER PRODUCT BARCODE");
       String barCode=sc.next();
       System.out.println("ENTER NEW COUNT");
       Integer count=sc.nextInt();
      Product product= productImpl.updateProductByCount(barCode,count);
       System.out.println(product);
   }
   public void removeProductOperation(){
       System.out.println("ENTER PRODUCT BARCODE");
       String barcode=sc.next();
       productImpl.removeProduct(barcode);
   }
   public void getAllProductOperation(){
      List<Product>productList= productImpl.getAllProduct();
       System.out.println(productList);
   }
   public void getProductByCatagory(){
       System.out.println(" ENTER PRODUCT CATEGORY\n"+
               "1.MEAT_PRODUCTS\n" +
               "2.DRINK \n" +
               "3.BEVERAGE_PRODUCTS \n" +
               "4.FLOUR_PRODUCTS \n" +
               "5.SEAFOOD");
       int count=sc.nextInt();
       switch (count){
           case 1:productImpl.getProductByCatagory(Catagory.MEAT_PRODUCTS);
           break;
           case 2:productImpl.getProductByCatagory(Catagory.DRINK);
           break;
           case 3:productImpl.getProductByCatagory(Catagory.BEVERAGE_PRODUCTS);
           break;
           case 4:productImpl.getProductByCatagory(Catagory.FLOUR_PRODUCTS);
           break;
           case 5:productImpl.getProductByCatagory(Catagory.SEAFOOD);
           break;
       }

   }
   public void getProductByPrice(){

       System.out.println("ENTER MIN PRICE");
       Double min=sc.nextDouble();
       System.out.println("ENTER MAX PRICE");
       Double max=sc.nextDouble();
       productImpl.getProductByPrice(min,max);
   }
   public void getProductByName(){
       System.out.println("ENTER PRODUCT NAME");
       String name= sc.next();
    Product product= productImpl.searchProductByName(name);
       System.out.println(product);

   }

}

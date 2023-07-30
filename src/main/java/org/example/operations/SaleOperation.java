package org.example.operations;

import org.example.models.Catagory;
import org.example.models.Product;
import org.example.models.Sale;
import org.example.models.SalesItem;
import org.example.service.impl.ProductImpl;
import org.example.service.impl.SaleImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaleOperation {
    public static SaleImpl saleImpl=new SaleImpl();
    static long id=0;
    static long idProduct=0;
    static  long idSaleItem=0;
    Scanner sc=new Scanner(System.in);

    public void addNewSaleOperation(){
        System.out.println("ENTER SALE NUM");
        Integer num=sc.nextInt();
        System.out.println("ENTER TOTAL");
        BigDecimal total=sc.nextBigDecimal();
        System.out.println("ENTER SALE ITEM");

        System.out.println("ENTER SALEITEM NUM");
        Integer num1=sc.nextInt();
        System.out.println("ENTER PRODUCT NAME");
        String name=sc.next();
        System.out.println("ENTER PRODUCT PRICE");
        BigDecimal price=sc.nextBigDecimal();
        System.out.println("ENTER PRODUCT CATAGORY"+"1.MEAT_PRODUCTS \n" +
                "2.DRINK \n" +
                "3.BEVERAGE_PRODUCTS \n" +
                "4.FLOUR_PRODUCTS \n" +
                "5.SEAFOOD");
        Integer ctg= sc.nextInt();
        Catagory catagory=null;
         if (ctg==1){
              catagory=Catagory.MEAT_PRODUCTS;
         } else if (ctg==2) {
              catagory=Catagory.DRINK;
         } else if (ctg==3) {
            catagory=Catagory.BEVERAGE_PRODUCTS;
         } else if (ctg==4) {
              catagory=Catagory.FLOUR_PRODUCTS;
         } else if (ctg==5) {
           catagory=Catagory.SEAFOOD;
         }
        System.out.println("ENTER PRODUCT COUNT");
         Integer count=sc.nextInt();
        System.out.println("ENTER PRODUCT BARCODE");
        String barCode= sc.next();
        System.out.println("ENTER COUNT ");
        Integer countSaleItem=sc.nextInt();


        Product product=new Product(idProduct++,name,price,catagory,count,barCode);

        SalesItem salesItem=new SalesItem(idSaleItem++,num1,product,countSaleItem);
        List<SalesItem>salesItems=new ArrayList<>();
        salesItems.add(salesItem);

        Sale sale=new Sale(id++,num,total,salesItems, LocalDateTime.now());
        saleImpl.addNewSale(sale);
    }
    public void addSaleOperation2(){
        System.out.println("ENTER SALE NUM");
        Integer num=sc.nextInt();
        System.out.println("ENTER SALE ITEM");

        System.out.println("ENTER SALEITEM NUM");
        Integer num1=sc.nextInt();
        System.out.println("ENTER PRODUCT BARCODE");
        String barCode= sc.next();
        System.out.println("ENTER COUNT");
        Integer count= sc.nextInt();
       Product product1= ProductImpl.products.stream()
               .filter(product -> product.getBarCode().equals(barCode)).findFirst().get();

        SalesItem salesItem=new SalesItem(idSaleItem++,num1,product1,count);
       int totalInt= salesItem.getProduct().getPrice().intValue()*count;
       BigDecimal tottal=new BigDecimal(totalInt);

       List<SalesItem>salesItems=new ArrayList<>();
       salesItems.add(salesItem);
       Sale sale=new Sale(id++,num,tottal,salesItems,LocalDateTime.now());
       saleImpl.addNewSale(sale);


    }
    public void returnProduct(){
        System.out.println("ENTER SALENUM");
        Integer saleNum= sc.nextInt();
        System.out.println("ENTER PRODUCT BARCODE");
        String barCode=sc.next();
        System.out.println("ENTER COUNT");
        Integer count= sc.nextInt();
        saleImpl.returnProduct(saleNum,barCode,count);
        System.out.println("THE OPERATION WAS EXECUTED");
    }
    public void removeSale(){
        System.out.println("ENTER SALE NUM");
        Integer saleNum=sc.nextInt();
        saleImpl.removeSale(saleNum);
    }
    public void getAllSales(){
        saleImpl.getAllSales();
    }
    public void saleByPrice(){
        System.out.println("ENTER MIN PRICE");
        BigDecimal minPrice=sc.nextBigDecimal();
        System.out.println("ENTER MAX PRICE");
        BigDecimal maxPrice=sc.nextBigDecimal();
        saleImpl.saleByPrice(minPrice,maxPrice);
    }
    public void getSaleByDate(){
        System.out.println("ENTER DATE :"+"yyyy-MM-ddTHH:mm:ss" );
       String date= sc.next();
       LocalDateTime localDateTime= LocalDateTime.parse(date);
       saleImpl.getSalesByDate(localDateTime);

    }
    public void getSaleBYNum(){
        System.out.println("ENTER SALE NUMBER");
        Integer num=sc.nextInt();
        saleImpl.getSaleByNum(num);

    }

}
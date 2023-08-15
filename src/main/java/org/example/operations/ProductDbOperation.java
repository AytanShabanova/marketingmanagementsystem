package org.example.operations;

import org.example.models.Catagory;
import org.example.models.Product;
import org.example.service.db.ProductDbImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ProductDbOperation {
    ProductDbImpl productDbImpl=new ProductDbImpl();
    static Scanner sc=new Scanner(System.in);


    public void addProductOp(){
        System.out.println("ENTER PRODUCT NAME");
        String name=sc.next();
        System.out.println("ENTER PRODUCT PRICE");
        BigDecimal price= sc.nextBigDecimal();
        System.out.println("ENTER COUNT");
        int count= sc.nextInt();
        System.out.println("ENTER BARCODE");
        String barCode= sc.next();
        System.out.println("  ENTER PRODUCT CATEGORY\n " +
                "1.MEAT_PRODUCTS \n" +
                "2.DRINK \n" +
                "3.BEVERAGE_PRODUCTS \n" +
                "4.FLOUR_PRODUCTS \n" +
                "5.SEAFOOD");
        int countctg=sc.nextInt();
        if (countctg==1){
            Product product=new Product(null,name,price, Catagory.MEAT_PRODUCTS,count,barCode);
            productDbImpl.addProduct(product);
            System.out.println(product);

        } else if (countctg==2) {
            Product product=new Product(null,name,price,Catagory.DRINK,count,barCode);
            productDbImpl.addProduct(product);
            System.out.println(product);

        } else if (countctg==3) {
            Product product=new Product(null,name,price,Catagory.BEVERAGE_PRODUCTS,count,barCode);
            productDbImpl.addProduct(product);
            System.out.println(product);

        } else if (countctg==4) {
            Product product=new Product(null,name,price,Catagory.FLOUR_PRODUCTS,count,barCode);
            productDbImpl.addProduct(product);
            System.out.println(product);

        } else if (countctg==5) {
            Product product=new Product(null,name,price,Catagory.SEAFOOD,count,barCode);
            productDbImpl.addProduct(product);
            System.out.println(product);


        }


    }
    public void updateProductByPriceOperation(){
        System.out.println("ENTER PRODUCT BARCODE");
        String barCode= sc.next();
        System.out.println("ENTER NEW PRICE");
        BigDecimal price=sc.nextBigDecimal();
        Product product= productDbImpl.updateProductByPrice(barCode,price);
        System.out.println(product);
    }
    public void updateProductByCountOperation(){
        System.out.println("ENTER PRODUCT BARCODE");
        String barCode=sc.next();
        System.out.println("ENTER NEW COUNT");
        Integer count=sc.nextInt();
        Product product= productDbImpl.updateProductByCount(barCode,count);
        System.out.println(product);
    }
    public void removeProductOperation(){
        System.out.println("ENTER PRODUCT BARCODE");
        String barcode=sc.next();
        productDbImpl.removeProduct(barcode);
    }
    public void getAllProductOperation(){
        List<Product> productList= productDbImpl.getAllProduct();
       productList.stream().forEach(product -> System.out.println(product));
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
            case 1:
                List<Product>productList= productDbImpl.getProductByCatagory(Catagory.MEAT_PRODUCTS);
                productList.stream().forEach(product -> System.out.println(product));
                break;
            case 2:
               List<Product> productList1= productDbImpl.getProductByCatagory(Catagory.DRINK);
               productList1.stream().forEach(product -> System.out.println(product));

                break;
            case 3:
                List<Product>productList2=productDbImpl.getProductByCatagory(Catagory.BEVERAGE_PRODUCTS);
                productList2.stream().forEach(product -> System.out.println(product));
                break;
            case 4:List<Product>productList3=productDbImpl.getProductByCatagory(Catagory.FLOUR_PRODUCTS);
            productList3.forEach(product -> System.out.println(product));
                break;
            case 5:List<Product>productList4=productDbImpl.getProductByCatagory(Catagory.SEAFOOD);
            productList4.stream().forEach(product -> System.out.println(product));
                break;
        }

    }
    public void getProductByPrice(){

        System.out.println("ENTER MIN PRICE");
        Double min=sc.nextDouble();
        System.out.println("ENTER MAX PRICE");
        Double max=sc.nextDouble();
        List<Product>productList=  productDbImpl.getProductByPrice(min,max);
        productList.stream().forEach(product -> System.out.println(product));
    }
    public void getProductByName(){
        System.out.println("ENTER PRODUCT NAME");
        String name= sc.next();
        Product product= productDbImpl.searchProductByName(name);
        System.out.println(product);

    }

}

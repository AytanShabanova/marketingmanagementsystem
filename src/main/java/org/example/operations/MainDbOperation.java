package org.example.operations;

import java.util.Scanner;

public class MainDbOperation {
    public static void main(String[] args) {
        start();
    }
  static   ProductDbOperation productDbOperation=new ProductDbOperation();
    public static void start(){
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println(" 1.ADD NEW PRODUCT\n 2.IMPROWE THE PRODUCT \n 3.DELETE THE PRODUCT \n " +
                    "4.SHOW ALL PRODUCTS \n 5.SHOW PRODUCTS BY CATEGORY \n " +
                    "6.SHOW PRODUCT BY PRICE RANGLE \n 7.SEARCH PRODUCTS BY NAME");
            int choice= sc.nextInt();
            if (choice==1){
                productDbOperation.addProductOp();
            } else if (choice==2) {
                System.out.println(" 1.UPDATE PRODUCT BY PRICE \n 2.UPDATE PRODUCT BY COUNT");
                choice = sc.nextInt();
                if (choice == 1) {
                    productDbOperation.updateProductByPriceOperation();

                } else if (choice == 2) {
                    productDbOperation.updateProductByCountOperation();

                }

            } else if (choice==3) {
                productDbOperation.removeProductOperation();

            } else if (choice==4) {
                productDbOperation.getAllProductOperation();
            } else if (choice==5) {
                productDbOperation.getProductByCatagory();

            } else if (choice==6) {
               productDbOperation.getProductByPrice();
            } else if (choice==7) {
                productDbOperation.getProductByName();
            }
        }
    }
}

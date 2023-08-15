package org.example.operations;

import java.util.Scanner;

public class MainOperation {
  static   ProductOperation productOperation = new ProductOperation();

  static   SaleOperation saleOperation = new SaleOperation();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
    MainOperation.Start();
    }

    public static void Start() {
        while (true) {
            System.out.println("  ENTER YOUR CHOICE\n1.PERFORM OPERATIONS ON PRODUCTS \n" +
                    "2.PERFORM OPERATIONS ON SALES \n" +
                    "3.EXIT THE SYSTEM ");
            Integer choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(" 1.ADD NEW PRODUCT\n 2.IMPROWE THE PRODUCT \n 3.DELETE THE PRODUCT \n " +
                            "4.SHOW ALL PRODUCTS \n 5.SHOW PRODUCTS BY CATEGORY \n " +
                            "6.SHOW PRODUCT BY PRICE RANGLE \n 7.SEARCH PRODUCTS BY NAME");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            productOperation.addProductOp();

                            break;
                        case 2:
                            System.out.println(" 1.UPDATE PRODUCT BY PRICE \n 2.UPDATE PRODUCT BY COUNT");
                            choice = sc.nextInt();
                            if (choice == 1) {
                                productOperation.updateProductByPriceOperation();

                            } else if (choice == 2) {
                                productOperation.updateProductByCountOperation();

                            }
                            break;
                        case 3:
                           productOperation.removeProductOperation();

                            break;
                        case 4:
                            productOperation.getAllProductOperation();
                            break;
                        case 5:
                            productOperation.getProductByCatagory();
                            break;
                        case 6:
                            productOperation.getProductByPrice();
                            break;
                        case 7:
                            productOperation.getProductByName();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("  1.ADD NEW SALE\n" +
                            "2.DELETE SALE ITEM \n" +
                            "3.DELETE SALE " +
                            "\n 4.SHOW ALL SALES \n" +
                            "5.SHOW SALES BY PRICE \n" +
                            "6.SHOW SALES BY DATE \n" +
                            "7.SHOW SALE BY NUMBER ");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            saleOperation.addSaleOp2();
                            break;
                        case 2:
                            saleOperation.returnProductOp();
                            break;
                        case 3:
                            saleOperation.removeSaleOp();
                            break;
                        case 4:
                            saleOperation.getAllSalesOp();
                            break;
                        case 5:
                            saleOperation.saleByPriceOp();
                            break;
                        case 6:
                            saleOperation.getSaleByDateOp();
                            break;
                        case 7:
                            saleOperation.getSaleBYNumOp();
                            break;
                    }
                    break;
                case 3:
                    System.exit(1);
                    break;
                default:
                    try {
                        throw  new Exception("ENTER CHOCICE CORRECT"){

                        };
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
            }

        }

    }
}
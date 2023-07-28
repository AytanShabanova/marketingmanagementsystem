package org.example.models;

public enum Catagory {

   MEAT_PRODUCTS(1,"MEAT_PRODUCTS"),
    DRINK(2,"DRINK"),
    BEVERAGE_PRODUCTS(3,"BEVERAGE_PRODUCTS"),
    FLOUR_PRODUCTS(4,"FLOUR_PRODUCTS"),
    SEAFOOD(5,"SEAFOOD") ,
    ;

    Catagory(Integer number, String note){
        this.note=note;
        this.number=number;
    }
    Integer number;
    String note;
}

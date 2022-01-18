package com.example.sdproject;

public class Customers {

    String product,price , quantity , name ,phonenumber;

    public Customers()
    {

    }

   // public Customers(String product, String price, String quantity) {
   //     this.product = product;
    //    this.price = price;
   //     this.quantity = quantity;

  //  }
    public Customers(String product, String price, String quantity, String name, String phonenumber) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.phonenumber = phonenumber;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}

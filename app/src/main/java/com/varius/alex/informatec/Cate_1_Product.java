package com.varius.alex.informatec;

public class Cate_1_Product {

    private int id;
    private String name;
    private String description;
    private int price;
    private int stock;
    private String img_url;

    public Cate_1_Product(int id, String name,String description, int price, int stock, String img_url) {
        this.id = id;
        this.name = name;
        this.description= description;
        this.price = price;
        this.stock = stock;
        this.img_url = img_url;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getdescription() {
        return description;
    }

    public int getprice() { return price; }

    public int getstock() { return stock; }

    public String getimg_url() { return img_url; }
}

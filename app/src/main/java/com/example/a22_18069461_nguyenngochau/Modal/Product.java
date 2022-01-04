package com.example.a22_18069461_nguyenngochau.Modal;

public class Product {
    String id;
    String type;
    String price;
    String content;
    String quantity;

    public Product(String id, String type, String price, String content, String quantity) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.content = content;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

package com.neuedu.test;

/**
 * Created by Daniel on 2020/2/12.
 */
public class MyBook {
    private String name;
    private Double price;
    private String press;
    private String author;
    private String bookISBN;
    public MyBook(String name, Double price, String press, String author, String bookISBN) {
        this.name = name;
        this.price = price;
        this.press = press;
        this.author = author;
        this.bookISBN = bookISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }
    public String toString(){
        return "name："+name+",price："+price+",press："+press+",author："+author+",ISBN码："+bookISBN;
    }

}

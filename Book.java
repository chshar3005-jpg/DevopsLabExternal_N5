package com.example.bookservice;

public class Book {
    private Integer id;
    private String bookname;
    private Integer bookcount;

    public Book() {
    }

    public Book(Integer id, String bookname, Integer bookcount) {
        this.id = id;
        this.bookname = bookname;
        this.bookcount = bookcount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getBookcount() {
        return bookcount;
    }

    public void setBookcount(Integer bookcount) {
        this.bookcount = bookcount;
    }
}

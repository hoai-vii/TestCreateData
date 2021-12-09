package com.example.model;

public class Book {
    private String bookName, bookAuthor, bookPublisher, dateTime,loaiBia, bookSize, bookCategory,bookSummary;
    private int bookID, bookPage;
    private  float ebookPrice, bookPrice;
    private byte[] bookImage;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLoaiBia() {
        return loaiBia;
    }

    public void setLoaiBia(String loaiBia) {
        this.loaiBia = loaiBia;
    }

    public String getBookSize() {
        return bookSize;
    }

    public void setBookSize(String bookSize) {
        this.bookSize = bookSize;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getBookSummary() {
        return bookSummary;
    }

    public void setBookSummary(String bookSummary) {
        this.bookSummary = bookSummary;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getBookPage() {
        return bookPage;
    }

    public void setBookPage(int bookPage) {
        this.bookPage = bookPage;
    }

    public float getEbookPrice() {
        return ebookPrice;
    }

    public void setEbookPrice(float ebookPrice) {
        this.ebookPrice = ebookPrice;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public byte[] getBookImage() {
        return bookImage;
    }

    public void setBookImage(byte[] bookImage) {
        this.bookImage = bookImage;
    }

    public Book(int bookID, String bookName, String bookAuthor, int bookPage, float ebookPrice, float bookPrice,String bookPublisher, String dateTime, String loaiBia, String bookSize, String bookCategory, String bookSummary,   byte[] bookImage) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.dateTime = dateTime;
        this.loaiBia = loaiBia;
        this.bookSize = bookSize;
        this.bookCategory = bookCategory;
        this.bookSummary = bookSummary;
        this.bookID = bookID;
        this.bookPage = bookPage;
        this.ebookPrice = ebookPrice;
        this.bookPrice = bookPrice;
        this.bookImage = bookImage;
    }
}


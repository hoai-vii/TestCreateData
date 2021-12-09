package com.example.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testcreatedata.MyDatabase;

import java.util.ArrayList;

public class BookDB {
    MyDatabase myDatabase;

    public BookDB(Context context){
        myDatabase = new MyDatabase(context);
    }

    public ArrayList<Book> getAll(){
        ArrayList<Book> dbBook = new ArrayList<>();
        Cursor cursor = myDatabase.getData("SELECT * FROM " + MyDatabase.TBL_NAME);
        while (cursor.moveToNext()){
            int id= cursor.getInt(0);
            String name = cursor.getString(1);
            String author = cursor.getString(2);
            int page = cursor.getInt(3);
            float eprice = cursor.getFloat(4);
            float price = cursor.getFloat(5);
            String publisher = cursor.getString(6);
            String datetime = cursor.getString(7);
            String loaiBia = cursor.getString(8);
            String size = cursor.getString(9);
            String category = cursor.getString(10);
            int image = cursor.getInt(11);
            String summary  =cursor.getString(12);
           // Book book = new Book(id,name, author, page, eprice, price, publisher, datetime, loaiBia, size, category, image, summary);
        }
        cursor.close();
        return dbBook;
    }
}

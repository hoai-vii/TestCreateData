package com.example.testcreatedata;

import static com.example.testcreatedata.MyDatabase.getBitmapAsByteArray;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.adapter.BookAdapterVertical;
import com.example.model.Book;
import com.example.model.BookDB;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcvMyBook;
    ArrayList<Book> books;
    BookAdapterVertical adapterVertical;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkView();
        prepareDB();
        initData();
    }

    private void linkView() {
        rcvMyBook = findViewById(R.id.rcvMyBook);
    }

    private void prepareDB() {
        db = new MyDatabase(this);
        Bitmap dacnhantam = BitmapFactory.decodeResource(getResources(),
                R.drawable.dacnhantam);
        db.insertData("Đắc nhân tâm","Dale Carnegie",320,15000,45000,"First News - Trí Việt","2016-03-18","Bìa cứng","14.5 x 20.5 cm","Sách mới",getBitmapAsByteArray(dacnhantam),"Đắc nhân tâm ...");
        Bitmap sinhtracvantay = BitmapFactory.decodeResource(getResources(),R.drawable.vongtronmau);
        db.insertData("Sinh trắc vân tay","RICHARD UNGER",444,85000,183000, "Nhà Xuất Bản Hồng Đức","2021-01-12","Bìa mềm","15 x 24.5 cm","Sách mới",getBitmapAsByteArray(sinhtracvantay),"Sinh trắc vân tay bla bla");
    }



    private void initData() {
        books = new ArrayList<>();
        Cursor cursor = db.getData("SELECT * FROM " + MyDatabase.TBL_NAME);
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
            byte[] image = cursor.getBlob(11);
            String summary  =cursor.getString(12);
            books.add(new Book(id,name, author, page, eprice, price, publisher, datetime, loaiBia, size, category, image, summary));
        }
        cursor.close();
        adapterVertical = new BookAdapterVertical(this, books);
        rcvMyBook.setAdapter(adapterVertical);
        rcvMyBook.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


    }
}
package com.example.testcreatedata;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "meraki_db.sqlite";
    public static final String TBL_NAME = "Book";
    public static final String COL_BOOK_ID = "Book_Id";
    public static final String COL_BOOK_NAME = "Book_Name";
    public static final String COL_BOOK_AUTHOR = "Book_Author";
    public static final String COL_BOOK_PAGE = "Book_Page";
    public static final String COL_BOOK_EPRICE = "Book_ePrice";
    public static final String COL_BOOK_PRICE = "Book_Price";
    public static final String COL_BOOK_PUBLISHER = "Book_Publisher";
    public static final String COL_BOOK_DATETIME = "Book_Datetime";
    public static final String COL_BOOK_LOAIBIA = "Book_LoaiBia";
    public static final String COL_BOOK_SIZE = "Book_Size";
    public static final String COL_BOOK_CATEGORY = "Book_Category";
    public static final String COL_BOOK_SUMMARY = "Book_Summary";
    public static final String COL_BOOK_IMAGE = "Book_Image";


    public MyDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + "(" + COL_BOOK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_BOOK_NAME + " VARCHAR(100), " + COL_BOOK_AUTHOR + " VARCHAR(50), " + COL_BOOK_PAGE + " INTEGER, " + COL_BOOK_EPRICE + " FLOAT, " + COL_BOOK_PRICE + " FLOAT, " +
                COL_BOOK_PUBLISHER +  " VARCHAR(200), " + COL_BOOK_DATETIME + " VARCHAR(20), " + COL_BOOK_LOAIBIA + " VARCHAR(20), " +
                COL_BOOK_SIZE + " VARCHAR(30), "+COL_BOOK_CATEGORY + " VARCHAR(100), " + COL_BOOK_IMAGE + " BLOB, " + COL_BOOK_SUMMARY + " VARCHAR(500)) " ;
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(sqLiteDatabase);
    }

    public void execSql(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql,null);
    }

//    public void createSomeDefaultBook(){
//        execSql("INSERT INTO "+ TBL_NAME+" VALUES(null,'Đắc nhân tâm','Dale Carnegie',320,15.000,45.000,'First News - Trí Việt','2016-03-18','Bìa cứng','14.5 x 20.5 cm','Sách mới',R.drawable.datnhantam,'Đắc nhân tâm ...'");
//
//
//       // Drawable drawable = MyDatabase.this.getResources().getDrawable(R.drawable.dacnhantam);
//       // Bitmap dacnhantam = drawableToBitmap(R.drawable.dacnhantam);
//
//    }


    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }

    public void insertData(String name, String author, int page, float eprice, float price, String publisher, String datetime, String LoaiBia, String size, String category, byte[] image, String summary) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_BOOK_NAME, name);
        cv.put(COL_BOOK_AUTHOR, author);
        cv.put(COL_BOOK_PAGE, page);
        cv.put(COL_BOOK_EPRICE, eprice);
        cv.put(COL_BOOK_PRICE, price);
        cv.put(COL_BOOK_PUBLISHER, publisher);
        cv.put(COL_BOOK_DATETIME, datetime);
        cv.put(COL_BOOK_LOAIBIA, LoaiBia);
        cv.put(COL_BOOK_SIZE, size);
        cv.put(COL_BOOK_CATEGORY, category);
        cv.put(COL_BOOK_IMAGE, image);
        cv.put(COL_BOOK_SUMMARY, summary);

        db.insert(TBL_NAME, null, cv);

    }
//
    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        final int width = !drawable.getBounds().isEmpty() ? drawable
                .getBounds().width() : drawable.getIntrinsicWidth();

        final int height = !drawable.getBounds().isEmpty() ? drawable
                .getBounds().height() : drawable.getIntrinsicHeight();

        final Bitmap bitmap = Bitmap.createBitmap(width <= 0 ? 1 : width,
                height <= 0 ? 1 : height, Bitmap.Config.ARGB_8888);

        Log.v("Bitmap width - Height :", width + " : " + height);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

}

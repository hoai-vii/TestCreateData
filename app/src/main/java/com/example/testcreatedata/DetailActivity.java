package com.example.testcreatedata;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.model.Book;
import com.example.model.BookItemClickListener;

public class DetailActivity extends AppCompatActivity implements BookItemClickListener {

    ImageView imvPhoto;
    TextView txtNameBook, txtPageBook, txtAuthorBook, txtDes, txtCategory;
    @Override
    public void onBookClick(Book book, ImageView bookImageView) {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_book);
        linkView();
        loadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    private void linkView() {
        imvPhoto = findViewById(R.id.imvPhoto);
        txtAuthorBook =findViewById(R.id.txtAuthorBook);
        txtNameBook = findViewById(R.id.txtNameBook);
        txtDes = findViewById(R.id.txtDes);
        txtPageBook = findViewById(R.id.txtPageBook);
        txtCategory = findViewById(R.id.txtCategory);

    }
    private void loadData() {
        Intent intent = getIntent();
        String bookName = intent.getExtras().getString("Title");
        String bookAuthor = intent.getExtras().getString("Author");
        int bookPage = intent.getExtras().getInt("Page");
        String Summary= intent.getExtras().getString("Summary");
        String Category = intent.getExtras().getString("Category");
    }
}

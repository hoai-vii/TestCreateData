package com.example.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Book;
import com.example.testcreatedata.R;

import java.util.ArrayList;
import java.util.List;

public class BookAdapterVertical extends RecyclerView.Adapter<BookAdapterVertical.ViewHolder> {
    Context context;
    ArrayList<Book> books;

    public BookAdapterVertical(Context context, ArrayList<Book> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public BookAdapterVertical.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.item_book,parent,false);
        return new ViewHolder(customView);
    }
    @Override
    public void onBindViewHolder(@NonNull BookAdapterVertical.ViewHolder holder, int position) {

        holder.txtNameVer.setText(books.get(position).getBookName());
        holder.txtAuthorVer.setText(books.get(position).getBookAuthor());
        holder.txtPageVer.setText(books.get(position).getBookPage());
        holder.btnRead.getContext();
        byte [] photo = books.get(position).getBookImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(photo, 0,photo.length);
        holder.imvBookVer.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvBookVer, imvStar, imvFavorite;
        TextView txtNameVer, txtAuthorVer, txtPageVer;
        Button btnRead;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imvBookVer = itemView.findViewById(R.id.imvBookVer);
            imvStar = itemView.findViewById(R.id.imvStarVer);
            imvFavorite = itemView.findViewById(R.id.imvFavorite);
            txtNameVer = itemView.findViewById(R.id.txtNameVer);
            txtAuthorVer = itemView.findViewById(R.id.txtAuthorVer);
            txtPageVer = itemView.findViewById(R.id.txtPageVer);
            btnRead = itemView.findViewById(R.id.btnRead);

            itemView.findViewById(R.id.btnRead).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

    }

}

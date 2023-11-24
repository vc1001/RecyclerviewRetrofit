package com.example.retrofitrecyclerapiex;


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitrecyclerapiex.databinding.ActivityMain2Binding;
import com.example.retrofitrecyclerapiex.model.Movie;
import com.example.retrofitrecyclerapiex.view.MovieAdapter;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

//    RecyclerView recyclerView;
//    ArrayList<Movie> movielist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  //      ActivityMain2Binding binding=DataBindingUtil.
              setContentView(R.layout.activity_main2);
        String original = getIntent().getStringExtra("originalTitle");
      int id= getIntent().getIntExtra("id",0);
        String backdrop = getIntent().getStringExtra("backdropPath");
        String originalLanguage=getIntent().getStringExtra("originalLanguage");
         String posterPath= getIntent().getStringExtra("posterPath");

       TextView textView= findViewById(R.id.og);
       TextView backdroptxt=findViewById(R.id.bd);
       TextView ol=findViewById(R.id.ol);
       TextView ov= findViewById(R.id.ov);
      TextView id1=findViewById(R.id.id1);
      ImageView imageView=findViewById(R.id.pp);



//        Movie movie = new Movie(original,id,backdrop,originalLanguage,overview,posterPath);
//
//        binding.setUser(movie);
//
//        binding.setLifecycleOwner(this);



        textView.setText(original);
        backdroptxt.setText(backdrop);
        ol.setText(originalLanguage);
        ov.setText(overview);
        id1.setText(String.valueOf(id));
        String imgPath = "https://image.tmdb.org/t/p/w500/" + posterPath;

        Glide.with(imageView.getContext()).load(imgPath).into(imageView);



    }
}
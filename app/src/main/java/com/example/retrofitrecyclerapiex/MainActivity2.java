package com.example.retrofitrecyclerapiex;


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitrecyclerapiex.databinding.ActivityMain2Binding;
import com.example.retrofitrecyclerapiex.model.Movie;
import com.example.retrofitrecyclerapiex.view.MovieAdapter;
import com.example.retrofitrecyclerapiex.viewmodel.MovieViewModel;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ActivityMain2Binding binding=DataBindingUtil.setContentView(this,R.layout.activity_main2);
  //   MovieViewModel ViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        String original = getIntent().getStringExtra("originalTitle");
       int id= getIntent().getIntExtra("id",0);
        String backdrop = getIntent().getStringExtra("backdropPath");
        String originalLanguage=getIntent().getStringExtra("originalLanguage");
        String overview= getIntent().getStringExtra("overview");
       String posterPath= getIntent().getStringExtra("posterPath");


        Movie movie = new Movie();
       movie.setOriginalTitle(original);
       movie.setBackdropPath(backdrop);
       movie.setId(id);
       movie.setOriginalLanguage(originalLanguage);
       movie.setOverview(overview);

        binding.setUser(movie);

 //       binding.setLifecycleOwner(this);
        String imgPath = "https://image.tmdb.org/t/p/w500/" + posterPath;
        Glide.with(this).load(imgPath).into(binding.pp);



    }
}
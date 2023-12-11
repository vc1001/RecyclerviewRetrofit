package com.example.retrofitrecyclerapiex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;

import com.example.retrofitrecyclerapiex.databinding.ActivityMainBinding;
import com.example.retrofitrecyclerapiex.model.Movie;
import com.example.retrofitrecyclerapiex.view.MovieAdapter;
import com.example.retrofitrecyclerapiex.viewmodel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerviewInterface {


    ActivityMainBinding activityMainBinding;
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;
    ArrayList<Movie> movieArrayList;
    MovieViewModel viewModel;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);



        getPopularMovies();

        swipeRefreshLayout = activityMainBinding.swiperefresh;
        swipeRefreshLayout.setColorSchemeColors(R.color.black);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovies();

            }
        });

    }

    private void getPopularMovies() {

        viewModel.getAllMovie().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> moviesFromLiveData) {
                movieArrayList = (ArrayList<Movie>) moviesFromLiveData;

                displayMovieInRecyclerView();
                swipeRefreshLayout.setRefreshing(false);


            }
        });
    }

    private void displayMovieInRecyclerView() {

        recyclerView = activityMainBinding.recyclerview;

        movieAdapter = new MovieAdapter(this , movieArrayList,this);
        recyclerView.setAdapter(movieAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));

        movieAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {

        Intent intent=new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("originalTitle",movieArrayList.get(position).getOriginalTitle());
        intent.putExtra("backdropPath",movieArrayList.get(position).getBackdropPath());
        intent.putExtra("originalLanguage",movieArrayList.get(position).getOriginalLanguage());
        intent.putExtra("overview",movieArrayList.get(position).getOverview());
       intent.putExtra("posterPath",movieArrayList.get(position).getPosterPath());
        intent.putExtra("id",movieArrayList.get(position).getId());

        startActivity(intent);

    }
}
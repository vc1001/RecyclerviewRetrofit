package com.example.retrofitrecyclerapiex.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitrecyclerapiex.R;
import com.example.retrofitrecyclerapiex.RecyclerviewInterface;
import com.example.retrofitrecyclerapiex.databinding.MovieItemListBinding;
import com.example.retrofitrecyclerapiex.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    Context context;
    ArrayList<Movie> movieArrayList;

    private final RecyclerviewInterface recyclerviewInterface;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList,RecyclerviewInterface recyclerviewInterface) {
        this.context = context;
        this.movieArrayList = movieArrayList;
        this.recyclerviewInterface= recyclerviewInterface;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MovieItemListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.movie_item_list, parent, false);
        return new MovieViewHolder(binding,recyclerviewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {

        Movie movie = movieArrayList.get(position);
        holder.moviesItemListBinding.setMovie(movie);
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        private MovieItemListBinding moviesItemListBinding;

        public MovieViewHolder(MovieItemListBinding moviesItemListBinding,RecyclerviewInterface recyclerviewInterface) {
            super(moviesItemListBinding.getRoot());
            this.moviesItemListBinding = moviesItemListBinding;

            moviesItemListBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerviewInterface!=null){
                    int postion = getAdapterPosition();
                    if(postion!=RecyclerView.NO_POSITION){
                        recyclerviewInterface.onItemClick(postion);
                    }
                }}
            });
        }
    }
}
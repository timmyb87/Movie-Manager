package com.twentyint.moviemanager.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.twentyint.moviemanager.R;
import com.twentyint.moviemanager.activities.MovieDetailActivity;
import com.twentyint.moviemanager.models.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {
	
	private List<Movie> movies;
	private Context context;
	
	public MovieRecyclerViewAdapter(Context context, List<Movie> movies) {
		this.movies = movies;
		this.context = context;
	}
	
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
		
		return new ViewHolder(v);
	}
	
	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		Movie movie = movies.get(position);
		holder.tvTitle.setText(movie.getTitle());
		holder.tvOverview.setText(movie.getOverview());
		Picasso.with(getContext())
				.load(movie.getPosterPath())
				.into(holder.ivMovieImage);
	}
	
	@Override
	public int getItemCount() {
		return movies.size();
	}
	
	private Context getContext(){
		return context;
	}
	
	public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		@BindView(R.id.ivMovieImage)
		ImageView ivMovieImage;
		@BindView(R.id.tvTitle)
		TextView tvTitle;
		@BindView(R.id.tvOverview)
		TextView tvOverview;
		@BindView(R.id.cvMovie)
		CardView cvMovie;
		
		ViewHolder(View view) {
			super(view);
			ButterKnife.bind(this, view);
			view.setOnClickListener(this);
		}
		
		@Override
		public void onClick(View view) {
			Movie movie = movies.get(getAdapterPosition());
			
			Intent i = new Intent(getContext(), MovieDetailActivity.class);
			i.putExtra("movie", movie);
			getContext().startActivity(i);
		}
	}
}

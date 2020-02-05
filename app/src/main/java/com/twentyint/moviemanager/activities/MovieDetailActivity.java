package com.twentyint.moviemanager.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;
import com.twentyint.moviemanager.R;
import com.twentyint.moviemanager.models.Movie;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity {
	Movie movie;
	@BindView(R.id.ivMovieBackdrop)
	ImageView ivMovieBackdrop;
	@BindView(R.id.tvOverview)
	TextView tvOverview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movie_detail);
		ButterKnife.bind(this);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Movie saved as favorite", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		Bundle extras = getIntent().getExtras();
		
		if (extras != null) {
			movie = (Movie) extras.getSerializable("movie");
			this.setTitle(movie.getTitle());
			tvOverview.setText(movie.getOverview());
			Picasso.with(this)
					.load(movie.getBackdropPath())
					.into(ivMovieBackdrop);
		}
	}
}

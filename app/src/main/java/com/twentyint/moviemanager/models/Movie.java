package com.twentyint.moviemanager.models;

import java.io.Serializable;

public class Movie implements Serializable {
	private String id, title, overview, posterPath, backdropPath;
	private float average, voteCount;
	
	public Movie(String id, String title, String overview, float average, float voteCount, String posterPath, String backdropPath) {
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.posterPath = posterPath;
		this.backdropPath = backdropPath;
		this.average = average;
		this.voteCount = voteCount;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getOverview() {
		return overview;
	}
	
	public void setOverview(String overview) {
		this.overview = overview;
	}
	
	public String getPosterPath() {
		return String.format("https://image.tmdb.org/t/p/w342%s", posterPath);
	}
	
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	
	public String getBackdropPath() {
		return String.format("https://image.tmdb.org/t/p/w780%s", backdropPath);
	}
	
	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}
	
	public float getAverage() {
		return average;
	}
	
	public void setAverage(float average) {
		this.average = average;
	}
	
	public float getVoteCount() {
		return voteCount;
	}
	
	public void setVoteCount(float voteCount) {
		this.voteCount = voteCount;
	}
}

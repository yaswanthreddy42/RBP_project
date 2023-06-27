package com.movieApp.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
//	@GeneratedValue
	private int movieId;
	String movieName;
	String theatreName;
	int seats;
	private int seatsAvalible;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getSeatsAvalible() {
		return seatsAvalible;
	}
	public void setSeatsAvalible(int seatsAvalible) {
		this.seatsAvalible = seatsAvalible;
	}
	
	
}

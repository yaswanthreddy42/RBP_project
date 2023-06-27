package com.movieApp.demo.Service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.movieApp.demo.Exception.DuplicateMovieIdExceptions;
import com.movieApp.demo.Model.Movie;

@Service
public interface MovieService {
	public List<Movie> getAllMovies();
	public Movie addMovie(Movie book) throws DuplicateMovieIdExceptions;
	public boolean deleteMovie(int mid);
	public Movie getMovieById(int mid);
	public boolean updateMovie(Movie movie);

}

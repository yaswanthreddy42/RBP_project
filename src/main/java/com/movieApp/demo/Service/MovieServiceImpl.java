package com.movieApp.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieApp.demo.Exception.DuplicateMovieIdExceptions;
import com.movieApp.demo.Model.Movie;
import com.movieApp.demo.Repository.MovieRepository;



@Service
public class MovieServiceImpl  implements MovieService{

	@Autowired
	private MovieRepository movieRepo;
	
	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movielist = movieRepo.findAll();
		if(movielist !=null && movielist.size() >0)
		{
			return movielist;
		}
		return null;
	}

	@Override
	public Movie addMovie(Movie movie) throws DuplicateMovieIdExceptions {
		Optional<Movie> opObj = movieRepo.findById(movie.getMovieId());
		
		if(opObj.isPresent())
		{
			throw new DuplicateMovieIdExceptions();
		}
		return movieRepo.saveAndFlush(movie);
	}

	@Override
	public boolean deleteMovie(int mid) {
		movieRepo.deleteById(mid);
		return true;
	}

	@Override
	public Movie getMovieById(int mid) {
		Optional<Movie> movie = movieRepo.findById(mid);
		if(movie.isPresent())
		{
			return movie.get();
		}
		
		return null;
	}

	@Override
	public boolean updateMovie(Movie movie) {
		Movie movie1 = movieRepo.getById(movie.getMovieId());
		if(movie1!=null)
		{
			movie1.setSeatsAvalible(movie.getSeatsAvalible());
			movie1.setMovieName(movie.getMovieName());
			movie1.setTheatreName(movie.getTheatreName());
			movieRepo.saveAndFlush(movie1);
			return true;
		}

		return false;
	}
	
	
}

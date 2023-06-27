package com.movieApp.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieApp.demo.Model.Movie;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}

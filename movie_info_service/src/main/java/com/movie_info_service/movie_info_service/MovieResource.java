package com.movie_info_service.movie_info_service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie_info_service.movie_info_models.Movie;
@RestController
@RequestMapping("/movies")
public class MovieResource {

	@RequestMapping("/{movieId}")	
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		
		return new Movie(movieId,"testname");
	}
}

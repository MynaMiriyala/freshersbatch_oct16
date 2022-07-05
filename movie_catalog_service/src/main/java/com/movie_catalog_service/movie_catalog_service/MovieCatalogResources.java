package com.movie_catalog_service.movie_catalog_service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Catalog")
public class MovieCatalogResources {
@Autowired 	
private RestTemplate restTemplate;

@RequestMapping("/{userId}")
public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
	
	UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRating.class);
	return ratings.getUserRating().stream().map(rating -> {
		
		Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
	
		
		
		return new CatalogItem(movie.getName(),"desc",rating.getRating());
	})
	.collect(Collectors.toList());
	
			
}
}


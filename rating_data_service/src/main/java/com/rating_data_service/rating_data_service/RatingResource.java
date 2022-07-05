package com.rating_data_service.rating_data_service;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating_data_service.rating_data_models.Rating;
import com.rating_data_service.rating_data_models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

	@RequestMapping("/{movieId}")	
	public Rating getRating(@PathVariable("movieId") String movieId) {
		
		return new Rating(movieId,4);
	}
	@RequestMapping("users/{userId}")	
	public UserRating getuserRating(@PathVariable("userId") String userId) {
		List <Rating> ratings = Arrays.asList(
				new Rating("1234",5),
				new Rating("5678",4)
					);
		
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}
}

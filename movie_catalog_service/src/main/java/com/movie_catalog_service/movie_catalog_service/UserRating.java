package com.movie_catalog_service.movie_catalog_service;

import java.util.List;

public class UserRating {
private List<Rating> userRating;

public List<Rating> getUserRating() {
	return userRating;
}

public void setUserRating(List<Rating> userRating) {
	this.userRating = userRating;
}

}

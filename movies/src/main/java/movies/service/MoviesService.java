package movies.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import movies.controller.model.ActorsData;
import movies.controller.model.GenresData;
import movies.controller.model.MoviesData;
import movies.dao.MoviesDao;
import movies.dao.GenresDao;
import movies.entity.Actors;
import movies.entity.Genres;
import movies.entity.Movies;

@Service
public class MoviesService {
@Autowired
private MoviesDao moviesDao;
//@Autowired
//private GenresDao genreDao;

@Transactional(readOnly = false)

	public MoviesData saveMovies(MoviesData moviesData) {
		Long movies_id = moviesData.getMovie_id();
		Movies movies = findOrCreateMovies(movies_id, moviesData.getTitle());
		
		setFieldsInMovies(movies, moviesData);
		return new MoviesData(moviesDao.save(movies));
		
	}

private void setFieldsInMovies(Movies movies, MoviesData moviesData) {
	movies.setDuration(moviesData.getDuration());
	movies.setTitle(moviesData.getTitle());
	movies.setRelease_year(moviesData.getRelease_year());
	
}

private Movies findOrCreateMovies(Long movies_id, String title) {
	Movies movies;
	
	if(Objects.isNull(movies_id)) {
		Optional<Movies> opTitle = moviesDao.findByTitle(title);
		
	if(opTitle.isPresent()) {
		throw new DuplicateKeyException("Title with title" +  title  +  " already exists.");
	}
		movies = new Movies();
	}
	else {
		movies = findMoviesById(movies_id);
	}
	return movies;
}

private Movies findMoviesById(Long movies_id) {
	return moviesDao.findById(movies_id)
			.orElseThrow(() -> new NoSuchElementException(
					"Movies with ID=" + movies_id + "was not found"));
}
@Transactional(readOnly = true)
public List<MoviesData> retrieveAllMovies() {
	List<Movies> movies = moviesDao.findAll();
	List<MoviesData> response = new LinkedList<>();
	
	for(Movies addmovies : movies) {
		response.add(new MoviesData(addmovies));
	}
	return response;
}
@Transactional(readOnly = true)
public MoviesData retrieveMoviesById(Long movie_id) {
	Movies movies = findMoviesById(movie_id);
	return new MoviesData(movies);
}
@Transactional(readOnly = false)
public void deleteMoviesById(Long movie_id) {
	Movies movies = findMoviesById(movie_id);
	moviesDao.delete(movies);
	
}
@Transactional(readOnly = false)
public ActorsData saveActors(Long movie_id, ActorsData actorsData) {
	Movies movies= findMoviesById(movie_id);
	return null;
}
@Transactional(readOnly = false)
public Genres saveGenres(Long movie_id, 
		GenresData genresData) {
	Movies movies = findMoviesById(movie_id); 
	Genres genres = findOrCreateMovies(movie_id, genres.getGenre_id());
	return movies;	

//	Set<Genres> genres = GenresData.findAllByGenresIn(moviesData.getGenres());
//	
//	Movies movies = findOrCreateMovies(MoviesData.getMovie_id());
//	setMoviesFields(movies, moviesData);
//	
//	movies.setActors(actors);
//	actors.getMovies().add(movies);
//	
//	Actors actors = findOrCreateActors(actorsData.getActor_id());

}

private Movies findOrCreateMovies(Long movie_id) {
	Movies movies;
	
	if(Objects.isNull(movie_id)) {
		movies = new Movies();
	}
	else {
		movies = findMoviesById(movie_id);
	}
	return movies;
}

}

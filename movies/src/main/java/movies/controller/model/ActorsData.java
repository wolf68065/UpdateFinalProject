package movies.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import movies.entity.Actors;


@Data
@NoArgsConstructor
public class ActorsData {
		private Long actor_id;
		private String actor_firstname;
		private String actor_lastname;
		Set<Movies> movies = new HashSet<>();
		
		public ActorsData(Actors actors) {
			actor_id = actors.getActor_id();
			actor_firstname = actors.getActor_firstname();
			actor_lastname = actors.getActor_lastname();
			
			for(Movies movie : actor_id.getMovies()) {
				movies.add(new Movies(movie));
		}	
	}	
		
		

	@Data
	@NoArgsConstructor
		static class Movies{
			
			private Long movie_id;
			private String title;
			private Long duration;
			private int release_year;
	
	public Movies(Movies movie) {
		movie_id = movie.getMovie_id();
		title = movie.getTitle();
		duration = movie.getDuration();
		release_year = movie.getRelease_year();
		
	}


		
	}	
		}

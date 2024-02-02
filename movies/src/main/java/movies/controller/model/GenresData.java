package movies.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import movies.entity.Genres;

@Data
@NoArgsConstructor
public class GenresData {
	    public Long genre_id;
		private String Action;
		private String Comedy;
		private String Romance;
		private String Drama;
		private String Family;
		private String Animation;
		Set<MoviesData>movies = new HashSet<>();
		
		
		
		public GenresData(Genres genres) {
		genre_id = genres.getGenre_id();
		Action = genres.getAction();
		Comedy = genres.getComedy();
		Romance =genres.getRomance();
		Drama = genres.getDrama();
		Family = genres.getFamily();
		Animation = genres.getAnimation();
		
		// for(Movies movie : genre_id.getMovies()) {
		// 	movies.add(new MoviesData(movie));
			
		// }
		
	}
@Data
@NoArgsConstructor
		static class Movies{
			private Long movie_id;
			private String title;
			private Long duration;
			private int release_year;
			
		Movies (Movies movies){
			movie_id = movies.getMovie_id();
			title = movies.getTitle();
			duration = movies.getDuration();
			release_year = movies.getRelease_year();
		}
		}
		
		
}

package movies.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import movies.entity.Genres;

public interface GenresDao extends JpaRepository<Genres, Long> {
	
	//Set<Genres>findAllByGenresIn(Set<String> genres);

}

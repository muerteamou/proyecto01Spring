package cf.iesguara.proyecto01Spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cf.iesguara.proyecto01Spring.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{
	
}

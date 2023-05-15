package cf.iesguara.proyecto01Spring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import cf.iesguara.proyecto01Spring.model.Film;


public interface FilmService {

	public ResponseEntity<List<Film>> getAllFilms();
	
	public Film getFilm(Long id);

	public ResponseEntity<Film> getById(long idFilm);

	public Film storeFilm(Film film);

	
	
	
}

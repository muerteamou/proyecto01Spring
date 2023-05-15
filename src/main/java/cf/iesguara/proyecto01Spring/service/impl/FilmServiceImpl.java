package cf.iesguara.proyecto01Spring.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cf.iesguara.proyecto01Spring.model.Film;
import cf.iesguara.proyecto01Spring.repository.FilmRepository;
import cf.iesguara.proyecto01Spring.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {

	FilmRepository filmRepository;
	
	public FilmServiceImpl(FilmRepository filmRepository) {
		super();
		this.filmRepository = filmRepository;
	}
	@Override
	public Film getFilm(Long id) {
		return filmRepository.getReferenceById(id);
	}


	@Override
	public ResponseEntity <List<Film>> getAllFilms(){
		return new ResponseEntity<List<Film>>(filmRepository.findAll(), HttpStatus.OK);
		
	}
	@Override
	public ResponseEntity<Film> getById(long idFilm) {
		return new ResponseEntity<Film>(filmRepository.findById(idFilm).get(), HttpStatus.OK);
	}
	@Override
	public Film storeFilm(Film film) {
		return filmRepository.save(film);

	}
}

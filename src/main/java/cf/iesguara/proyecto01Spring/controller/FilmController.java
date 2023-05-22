package cf.iesguara.proyecto01Spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cf.iesguara.proyecto01Spring.model.Film;
import cf.iesguara.proyecto01Spring.service.FilmService;

@RestController
@RequestMapping("/peliculas")
public class FilmController {

	private FilmService filmService;

	public FilmController(FilmService filmService) {
		super();
		this.filmService = filmService;
	}

	// API

	// GET
	@GetMapping("todas")
	public ResponseEntity<List<Film>> getAllFilms() {
		return filmService.getAllFilms();

	}

	// getById parámetro de tipo GET
	// peliculas?id=1 <-- para capturar el parámetro de ña

	@GetMapping
	public ResponseEntity<Film> showFilmRequestParam(@RequestParam("id") String idFilm) {
		return filmService.getById(Long.valueOf(idFilm));
	}

	// getById parámeotro includio en el endpoint
	// GET /peliculas/1 <-- para capturar la variable en el endpoint es pathvariable

	@GetMapping("/{id}")
	public ResponseEntity<Film> showFilm(@PathVariable("id") Long idFilm) {
		return filmService.getById(idFilm);
	}

	// API : POST

	// POST /peliculas
	@PostMapping()
	public ResponseEntity<Film> storeFilm(@RequestBody Film film) {
		return new ResponseEntity<Film>(filmService.storeFilm(film), HttpStatus.CREATED);
	}
	
	

}

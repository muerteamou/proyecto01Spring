package cf.iesguara.proyecto01Spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cf.iesguara.proyecto01Spring.model.Fabricante;
import cf.iesguara.proyecto01Spring.service.FabricanteService;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

	private FabricanteService fabricanteService;

	public FabricanteController(FabricanteService fabricanteService) {
		super();
		this.fabricanteService = fabricanteService;
	}

	@PostMapping
	public ResponseEntity<Fabricante> save(@RequestBody Fabricante fabricante) {

		return new ResponseEntity<Fabricante>(fabricanteService.save(fabricante), HttpStatus.CREATED);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Fabricante> getByName(@PathVariable("name") String name) {
		return new ResponseEntity<Fabricante>(fabricanteService.findByName(name), HttpStatus.OK);
	}

	@GetMapping
	public List<Fabricante> findAll() {
		return fabricanteService.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Fabricante> find(@PathVariable("id") long idFabricante) {
		return new ResponseEntity<Fabricante>(fabricanteService.find(idFabricante), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Fabricante> update(@PathVariable("id") long idFabricante,
			@RequestBody Fabricante fabricante) {
		return new ResponseEntity<Fabricante>(fabricanteService.update(idFabricante, fabricante), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Fabricante> delete(@PathVariable("id") long idFabricante) {
		return new ResponseEntity<Fabricante>(fabricanteService.delete(idFabricante), HttpStatus.ACCEPTED);
	}

}

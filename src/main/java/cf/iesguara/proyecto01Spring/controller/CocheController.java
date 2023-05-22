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

import cf.iesguara.proyecto01Spring.model.Coche;
import cf.iesguara.proyecto01Spring.service.CocheService;


@RestController
@RequestMapping("/coches")
public class CocheController {

	private CocheService cocheService;


	public CocheController(CocheService cocheService) {
		super();
		this.cocheService = cocheService;
	}

	// Aqui empieza la APIREST

	@PostMapping("/{fabricante}")
	public ResponseEntity<Coche> save(@PathVariable("fabricante") String name, @RequestBody Coche coche) {

		//Fabricante fabricante = fabricanteService.find(coche.getFabricante().getId());
		//coche.setFabricante(fabricante);
		return new ResponseEntity<Coche>(cocheService.save(coche, name), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Coche> findAll() {
		return cocheService.findAll();
	}

//	@GetMapping("{fabricante/name}")
//	public List<Coche> findByManufacturer(@PathVariable("name") String name) {
//		return (List<Coche>) cocheService.findByManufacturer(name);
//	}

	@GetMapping("{id}")
	public ResponseEntity<Coche> findById(@PathVariable("id") long id) {
		return new ResponseEntity<Coche>(cocheService.findById(id), HttpStatus.ACCEPTED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Coche> update(@PathVariable("id") long idCoche, @RequestBody Coche coche) {
		return new ResponseEntity<Coche>(cocheService.update(idCoche, coche), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Coche> delete(@PathVariable("id") long idCoche) {
		return new ResponseEntity<Coche>(cocheService.delete(idCoche), HttpStatus.ACCEPTED);
	}
	


}

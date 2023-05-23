package cf.iesguara.proyecto01Spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cf.iesguara.proyecto01Spring.exception.RecursoNoEncontradoException;
import cf.iesguara.proyecto01Spring.model.Coche;
import cf.iesguara.proyecto01Spring.model.Fabricante;
import cf.iesguara.proyecto01Spring.repository.CocheRepository;
import cf.iesguara.proyecto01Spring.repository.FabricanteRepository;
import cf.iesguara.proyecto01Spring.service.CocheService;

@Service
public class CocheServiceImpl implements CocheService {

	private CocheRepository cocheRepository;

	@Autowired
	private FabricanteRepository fabricanteRepository;

	public CocheServiceImpl(CocheRepository cocheRepository) {
		super();
		this.cocheRepository = cocheRepository;
	}

	@Override
	public Coche save(Coche coche, String name) {
		Optional<Fabricante> fabricante = fabricanteRepository.findByName(name);
		if (fabricante.isPresent()) {
			coche.setFabricante(fabricante.get());
			return cocheRepository.save(coche);
		}
		throw new RecursoNoEncontradoException("Fabricante", "nombre", name);
	}

	@Override
	public Coche update(long id, Coche coche) {
		Optional<Coche> result = cocheRepository.findById(id);
		if (result.isPresent()) {
			coche.setId(id);
			coche.setFabricante(result.get().getFabricante());
			return cocheRepository.save(coche);
		} else {
			throw new RecursoNoEncontradoException("Coche", "id", id);
		}
	}

	@Override
	public Coche delete(long id) {
		Optional<Coche> result = cocheRepository.findById(id);
		if (result.isPresent()) {
			cocheRepository.deleteById(result.get().getId());
			return result.get();
		} else {
			throw new RecursoNoEncontradoException("Coche", "id", id);
		}

	}

	@Override
	public List<Coche> findAll() {
		return cocheRepository.findAll();
	}

	public Coche findById(long id) {
		Optional<Coche> coche = cocheRepository.findById(id);
		if (coche.isPresent()) {
			return coche.get();
		} else
			throw new RecursoNoEncontradoException("Coche", "id", id);
	}

	@Override
	public Coche delete(Coche coche) {
		cocheRepository.delete(coche);
		return coche;
	}

}

package cf.iesguara.proyecto01Spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cf.iesguara.proyecto01Spring.exception.RecursoNoEncontradoException;
import cf.iesguara.proyecto01Spring.model.Fabricante;
import cf.iesguara.proyecto01Spring.repository.FabricanteRepository;
import cf.iesguara.proyecto01Spring.service.FabricanteService;

@Service
public class FabricanteServiceImpl implements FabricanteService {

	@Autowired
	private FabricanteRepository fabricanteRepository;

	public FabricanteServiceImpl(FabricanteRepository fabricanteRepository) {
		super();
		this.fabricanteRepository = fabricanteRepository;
	}


	@Override
	public Fabricante save(Fabricante fabricante) {
		return fabricanteRepository.save(fabricante);
	}

	@Override
	public List<Fabricante> findAll() {

		return fabricanteRepository.findAll();
	}

	@Override
	public Fabricante find(long id) {
		Optional<Fabricante> fabricante = fabricanteRepository.findById(id);
		if (fabricante.isPresent()) {
			return fabricante.get();
		} else {
			throw new RecursoNoEncontradoException("Fabricante", "id", id);
		}
	}

	@Override
	public Fabricante update(long id, Fabricante fabricante) {

		Optional<Fabricante> result = fabricanteRepository.findById(id);
		if (result.isPresent()) {
			fabricante.setId(id);
			return fabricanteRepository.save(fabricante);
		} else {
			throw new RecursoNoEncontradoException("Fabricante", "id", id);
		}

	}

	@Override
	public Fabricante delete(long id) {
		Optional<Fabricante> result = fabricanteRepository.findById(id);
		if (result.isPresent()) {
			fabricanteRepository.deleteById(id);
			return result.get();
		} else {
			throw new RecursoNoEncontradoException("Fabricante", "id", id);
		}

	}

	@Override
	public Fabricante findByName(String name) {
		Optional<Fabricante> result = fabricanteRepository.findByName(name);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RecursoNoEncontradoException("Fabricante", "name", name);
		}

	}


	@Override
	public Fabricante update(Fabricante fabricante) {
		return fabricanteRepository.save(fabricante);
	}

}

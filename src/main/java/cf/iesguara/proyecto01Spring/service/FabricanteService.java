package cf.iesguara.proyecto01Spring.service;

import java.util.List;

import cf.iesguara.proyecto01Spring.model.Fabricante;

public interface FabricanteService {

	public Fabricante save(Fabricante fabricante);

	public List<Fabricante> findAll();

	public Fabricante find(long id);

	public Fabricante update(long id, Fabricante fabricante);
	
	public Fabricante delete(long id);
	
	public Fabricante findByName(String name);
	
	public Fabricante update(Fabricante fabricante);
}

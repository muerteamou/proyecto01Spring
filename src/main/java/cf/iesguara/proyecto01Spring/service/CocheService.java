package cf.iesguara.proyecto01Spring.service;

import java.util.List;

import cf.iesguara.proyecto01Spring.model.Coche;

public interface CocheService {

	public Coche save(Coche coche, String name);

	public List<Coche> findAll();

	public Coche findById(long id);

	public Coche update(long id, Coche coche);

	public Coche delete(long id);

	public Coche delete(Coche coche);

}

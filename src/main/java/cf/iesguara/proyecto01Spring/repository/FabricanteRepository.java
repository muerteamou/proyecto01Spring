package cf.iesguara.proyecto01Spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cf.iesguara.proyecto01Spring.model.Fabricante;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

	Optional<Fabricante> findByName(String name);

}

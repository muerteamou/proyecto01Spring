package cf.iesguara.proyecto01Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cf.iesguara.proyecto01Spring.model.Coche;

public interface CocheRepository extends JpaRepository<Coche, Long> {

}

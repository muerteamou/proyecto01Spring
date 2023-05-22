package cf.iesguara.proyecto01Spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import cf.iesguara.proyecto01Spring.model.Coche;

public interface CocheRepository extends JpaRepository<Coche, Long>{

//	@Query("SELECT c FROM coche c WHERE c.nombre = :name")
//	List<Coche> findByName(@Param("name") String name);
	
}

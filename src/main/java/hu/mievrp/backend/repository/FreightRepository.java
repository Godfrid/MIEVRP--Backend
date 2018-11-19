package hu.mievrp.backend.repository;

import hu.mievrp.backend.model.Freight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreightRepository extends JpaRepository<Freight, Long> {
}

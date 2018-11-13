package hu.mievrp.backend.repository;

import hu.mievrp.backend.model.Driver;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{
}

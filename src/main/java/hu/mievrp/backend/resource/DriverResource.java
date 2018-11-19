package hu.mievrp.backend.resource;

import hu.mievrp.backend.service.DriverService;
import hu.mievrp.backend.service.dto.DriverDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverResource {
    private final DriverService driverService;

    public DriverResource(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DriverDTO>> findAll() {
        return ResponseEntity.ok(driverService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDTO> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(driverService.findOne(id));
    }

    @PostMapping("/")
    public ResponseEntity<DriverDTO> save(@RequestBody DriverDTO driverDTO) {
        return ResponseEntity.ok(driverService.save(driverDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        driverService.delete(id);
        return ResponseEntity.ok().build();
    }
}
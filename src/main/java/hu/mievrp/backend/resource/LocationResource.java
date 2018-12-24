package hu.mievrp.backend.resource;


import hu.mievrp.backend.model.Location;
import hu.mievrp.backend.service.LocationService;
import hu.mievrp.backend.service.dto.LocationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationResource {

    private final LocationService locationService;

    public LocationResource(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/")
    public ResponseEntity<List<LocationDTO>> findAll() {
        return ResponseEntity.ok(locationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.findOne(id));
    }

    @PostMapping("/")
    public ResponseEntity<LocationDTO> save(@RequestBody LocationDTO locationDTO) {
        return ResponseEntity.ok(locationService.save(locationDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        locationService.delete(id);
        return ResponseEntity.ok().build();
    }

}

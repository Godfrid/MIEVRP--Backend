package hu.mievrp.backend.service;

import hu.mievrp.backend.model.Location;
import hu.mievrp.backend.repository.LocationRepository;
import hu.mievrp.backend.service.dto.LocationDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) { this.locationRepository = locationRepository;}

    @Transactional(readOnly = true)
    public LocationDTO findOne(Long id) { return locationRepository.findById(id).map(this::toDto).orElse(null); }

    @Transactional(readOnly = true)
    public List<LocationDTO> findAll() { return toDto(locationRepository.findAll()); }

    public LocationDTO save(LocationDTO locationDto) { return toDto(locationRepository.save(toEntity(locationDto))); }

    public void delete(Long id) { locationRepository.deleteById(id);}

    public LocationDTO toDto(Location location) {
        if (location == null) return null;

        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setId(location.getId());
        locationDTO.setCountry(location.getCountry());
        locationDTO.setCity(location.getCity());
        locationDTO.setZIP(location.getZIP());
        locationDTO.setAddress(location.getAddress());

        return locationDTO;
    }

    public List<LocationDTO> toDto(List<Location> locations) {
        return locations.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Location toEntity(LocationDTO locationDTO) {
        if (locationDTO == null) return null;

        Location location = new Location();

        location.setId(locationDTO.getId());
        location.setCountry(locationDTO.getCountry());
        location.setCity(locationDTO.getCity());
        location.setZIP(locationDTO.getZIP());
        location.setAddress(locationDTO.getAddress());

        return location;
    }

}

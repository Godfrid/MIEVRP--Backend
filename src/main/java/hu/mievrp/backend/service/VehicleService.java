package hu.mievrp.backend.service;

import hu.mievrp.backend.model.Driver;
import hu.mievrp.backend.model.Vehicle;
import hu.mievrp.backend.repository.VehicleRepository;
import hu.mievrp.backend.service.dto.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VehicleService {

    @Autowired
    DriverService driverService;

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional(readOnly = true)
    public VehicleDTO findOne(Long id) {
        return vehicleRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<VehicleDTO> findAll() {
        return toDto(vehicleRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Vehicle findOneDirect(Long id) { return vehicleRepository.findById(id).orElse(null); }

    public VehicleDTO save(VehicleDTO vehicleDto) {
        return toDto(vehicleRepository.save(toEntity(vehicleDto)));
    }

    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

    public VehicleDTO toDto(Vehicle vehicle) {
        if (vehicle == null) return null;

        VehicleDTO vehicleDTO = new VehicleDTO();

        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setPlateNumber(vehicle.getPlateNumber());
        vehicleDTO.setType(vehicle.getType());
        vehicleDTO.setEURClass(vehicle.getEURClass());
        vehicleDTO.setCarryingCapacity(vehicle.getCarryingCapacity());
        vehicleDTO.setDriverIds(vehicle.getDrivers()
                    .stream().map(Driver::getId)
                    .collect(Collectors.toList()));

        return vehicleDTO;
    }

    public List<VehicleDTO> toDto(List<Vehicle> vehicles) {
        return vehicles.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Vehicle toEntity(VehicleDTO vehicleDTO) {
        if (vehicleDTO == null) return null;

        Vehicle vehicle = new Vehicle();

        vehicle.setId(vehicleDTO.getId());
        vehicle.setPlateNumber(vehicleDTO.getPlateNumber());
        vehicle.setType(vehicleDTO.getType());
        vehicle.setEURClass(vehicleDTO.getEURClass());
        vehicle.setCarryingCapacity(vehicleDTO.getCarryingCapacity());
        vehicle.setDrivers(vehicleDTO.getDriverIds()
                .stream().map(driverId -> driverService.findOneDirect(driverId))
                .collect(Collectors.toList()));

        return vehicle;
    }

}

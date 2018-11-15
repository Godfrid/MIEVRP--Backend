package hu.mievrp.backend.service;

import hu.mievrp.backend.model.Vehicle;
import hu.mievrp.backend.repository.VehicleRepository;
import hu.mievrp.backend.service.dto.VehicleDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service

public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleDTO findOne(Long id) {
        return vehicleRepository.findById(id).map(this::toDto).orElse(null);
    }

    public List<VehicleDTO> findAll() {
        return toDto(vehicleRepository.findAll());
    }

    public VehicleDTO save(VehicleDTO vehicleDto) {
        return toDto(vehicleRepository.save(toEntity(vehicleDto)));
    }

    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }


    public VehicleDTO toDto(Vehicle vehicle) {
        if (vehicle == null) return null;

        VehicleDTO vehicleDto = new VehicleDTO();

        vehicleDto.setId(vehicle.getId());
        vehicleDto.setPlateNumber(vehicle.getPlateNumber());
        vehicleDto.setType(vehicle.getType());
        vehicleDto.setEURClass(vehicle.getEURClass());
        vehicleDto.setCarryingCapacity(vehicle.getCarryingCapacity());

        return vehicleDto;
    }

    public List<VehicleDTO> toDto(List<Vehicle> vehicles) {
        return vehicles.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Vehicle toEntity(VehicleDTO vehicleDto) {
        if (vehicleDto == null) return null;

        Vehicle vehicle = new Vehicle();

        vehicle.setId(vehicleDto.getId());
        vehicle.setPlateNumber(vehicleDto.getPlateNumber());
        vehicle.setType(vehicleDto.getType());
        vehicle.setEURClass(vehicleDto.getEURClass());
        vehicle.setCarryingCapacity(vehicleDto.getCarryingCapacity());

        return vehicle;
    }
}

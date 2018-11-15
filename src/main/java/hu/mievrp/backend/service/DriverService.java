package hu.mievrp.backend.service;

import hu.mievrp.backend.model.Driver;
import hu.mievrp.backend.repository.DriverRepository;
import hu.mievrp.backend.service.dto.DriverDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }




    @Transactional(readOnly = true)
    public DriverDTO findOne(Long id) {
        return driverRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<DriverDTO> findAll() {
        return toDto(driverRepository.findAll());
    }

    public DriverDTO save(DriverDTO driverDto) {
        // driverRepository.save(toEntity(driverDto));
        return toDto(driverRepository.save(toEntity(driverDto)));
    }

    public void delete(Long id) {
        driverRepository.deleteById(id);
    }




    public DriverDTO toDto(Driver driver) {
        if(driver == null) return null;

        DriverDTO driverDto = new DriverDTO();

        driverDto.setId(driver.getId());
        driverDto.setName(driver.getName());

        return driverDto;
    }

    public List<DriverDTO> toDto(List<Driver> drivers) {
        return drivers.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Driver toEntity(DriverDTO driverDto) {
        if(driverDto == null) return null;

        Driver driver = new Driver();

        driver.setId(driverDto.getId());
        driver.setName(driverDto.getName());

        return driver;
    }
}

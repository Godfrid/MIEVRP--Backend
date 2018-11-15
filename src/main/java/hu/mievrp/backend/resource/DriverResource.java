package hu.mievrp.backend.resource;

import hu.mievrp.backend.service.DriverService;
import hu.mievrp.backend.service.dto.DriverDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverResource {
    private final DriverService driverService;

    public DriverResource(DriverService driverService) {
        this.driverService = driverService;
    }


    @GetMapping("/")
    public List<DriverDTO> findAll() {
        return driverService.findAll();
    }

}

package hu.mievrp.backend.service.dto;

import java.util.ArrayList;
import java.util.List;

public class VehicleDTO {

    private Long id;

    private String plateNumber;

    private String type;

    private Integer EURClass;

    private Integer carryingCapacity;

    private List<Long> driverIds = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEURClass() {
        return EURClass;
    }

    public void setEURClass(Integer EURClass) {
        this.EURClass = EURClass;
    }

    public Integer getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(Integer carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public List<Long> getDriverIds() {
        return driverIds;
    }

    public void setDriverIds(List<Long> driverIds) {
        this.driverIds = driverIds;
    }
}

package hu.mievrp.backend.service.dto;

import hu.mievrp.backend.service.DriverService;

import java.util.ArrayList;

public class DriverDTO {
    private Long id;

    private String name;

    private ArrayList<Long> vehicleIds = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Long> getVehicleIds() {
        return vehicleIds;
    }

    public void setVehicleIds(ArrayList<Long> vehicleIds) {
        this.vehicleIds = vehicleIds;

    }
}


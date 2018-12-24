package hu.mievrp.backend.service.dto;

import java.util.ArrayList;
import java.util.List;

public class LocationDTO {

    private Long id;

    private String country;

    private String city;

    private String ZIP;

    private String address;

    private Long partnerId;

    private List<Long> freightIds = new ArrayList<>();

    // TODO: 1. TYPE OF LOCATION UN- /LOADING  or NEITHER; 2. SAVED/NOT SAVED. 3. MAYBE: COMMENT.


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZIP() {
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public List<Long> getFreightIds() {
        return freightIds;
    }

    public void setFreightIds(List<Long> freightIds) {
        this.freightIds = freightIds;
    }
}

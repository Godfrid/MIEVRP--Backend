package hu.mievrp.backend.service.dto;

public class LocationDTO {

    private Long id;

    private String country;

    private String city;

    private Integer ZIP;

    private String address;

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

    public Integer getZIP() {
        return ZIP;
    }

    public void setZIP(Integer ZIP) {
        this.ZIP = ZIP;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

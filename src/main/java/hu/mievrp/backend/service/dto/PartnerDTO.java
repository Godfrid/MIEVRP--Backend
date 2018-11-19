package hu.mievrp.backend.service.dto;

import java.util.ArrayList;
import java.util.List;

public class PartnerDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private List<Long> locationIds = new ArrayList<>();

    private List<Long> invoiceIds = new ArrayList<>();

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Long> getLocationIds() { return locationIds; }

    public void setLocationIds(List<Long> locationIds) { this.locationIds = locationIds; }

    public List<Long> getInvoiceIds() { return invoiceIds; }

    public void setInvoiceIds(List<Long> invoiceIds) { this.invoiceIds = invoiceIds; }
}

package hu.mievrp.backend.service.dto;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDTO {

    private Long id;

    private Double netCost;

    private Double grossCost;

    private Double VAT;

    private String currency;

    private String date;

    private String fulfilmentDate;

    private List<Long> freightIds = new ArrayList<>();

    private Long partnerId;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Double getNetCost() {
        return netCost;
    }

    public void setNetCost(Double netCost) {
        this.netCost = netCost;
    }

    public Double getGrossCost() {
        return grossCost;
    }

    public void setGrossCost(Double grossCost) {
        this.grossCost = grossCost;
    }

    public Double getVAT() {
        return VAT;
    }

    public void setVAT(Double VAT) {
        this.VAT = VAT;
    }

    public String getCurrency() { return currency; }

    public void setCurrency(String currency) { this.currency = currency; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getFulfilmentDate() { return fulfilmentDate; }

    public void setFulfilmentDate(String fulfilmentDate) { this.fulfilmentDate = fulfilmentDate; }

    public List<Long> getFreightIds() { return freightIds; }

    public void setFreightIds(List<Long> freightIds) { this.freightIds = freightIds; }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
}

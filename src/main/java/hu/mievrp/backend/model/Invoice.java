package hu.mievrp.backend.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column
    private Double netCost;

    @Column
    private Double grossCost;

    @Column
    private Double VAT;

    @Column
    private String currency;

    @Column
    private String date;

    @Column
    private String fulfilmentDate;

    @ManyToMany (mappedBy = "invoices", fetch = FetchType.LAZY)
    private List<Freight> freights = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "partner_id")
    private Partner partner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFulfilmentDate() {
        return fulfilmentDate;
    }

    public void setFulfilmentDate(String fulfilmentDate) {
        this.fulfilmentDate = fulfilmentDate;
    }

    public List<Freight> getFreights() {
        return freights;
    }

    public void setFreights(List<Freight> freights) {
        this.freights = freights;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}

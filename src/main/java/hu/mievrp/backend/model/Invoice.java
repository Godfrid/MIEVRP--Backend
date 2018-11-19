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
    private Long netCost;

    @Column
    private Long grossCost;

    @Column
    private Long VAT;

    private String currency;

    @Column
    private String date;

    @Column
    private String fulfilmentDate;

    @ManyToMany (mappedBy = "invoices", fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    private List<Freight> freights = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    @JoinColumn(name = "partner_id", nullable = false)
    private Partner partner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNetCost() {
        return netCost;
    }

    public void setNetCost(Long netCost) {
        this.netCost = netCost;
    }

    public Long getGrossCost() {
        return grossCost;
    }

    public void setGrossCost(Long grossCost) {
        this.grossCost = grossCost;
    }

    public Long getVAT() {
        return VAT;
    }

    public void setVAT(Long VAT) {
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

package hu.mievrp.backend.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "freight")
public class Freight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
// TODO: UNIQUE ID TO Generate and store catalog numbers(Inner reference).
    @Column
    private String startDate;

    @Column
    private String endDate;

    @Column
    private String fulfilmentDate;

    @Column
    private Long startingKm;

    @Column
    private Long finishingKm;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            inverseJoinColumns =
                    @JoinColumn(name = "location_id"),
            joinColumns =
                    @JoinColumn(name = "freight_id"))
    private List<Location> locations = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            inverseJoinColumns =
            @JoinColumn(name = "invoice_id"),
            joinColumns =
            @JoinColumn(name = "freight_id"))
    private List<Invoice> invoices = new ArrayList<>();

    @Column
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFulfilmentDate() {
        return fulfilmentDate;
    }

    public void setFulfilmentDate(String fulfilmentDate) {
        this.fulfilmentDate = fulfilmentDate;
    }

    public Long getStartingKm() {
        return startingKm;
    }

    public void setStartingKm(Long startingKm) {
        this.startingKm = startingKm;
    }

    public Long getFinishingKm() {
        return finishingKm;
    }

    public void setFinishingKm(Long finishingKm) {
        this.finishingKm = finishingKm;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

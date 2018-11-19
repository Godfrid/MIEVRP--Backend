package hu.mievrp.backend.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "freight")
public class Freight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String startingDate;

    @Column
    private String finishingDate;

    @Column
    private String fulfilmentDate;

    @Column
    private Long startingKm;

    @Column
    private Long finishingKm;

    @Column
    private String startingPlace;

    @Column
    private String finishingPlace;

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

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getFinishingDate() {
        return finishingDate;
    }

    public void setFinishingDate(String finishingDate) {
        this.finishingDate = finishingDate;
    }

    public String getFulfilmentDate() {
        return fulfilmentDate;
    }

    public void setFulfilmentDate(String fulfilmentDate) {
        this.fulfilmentDate = fulfilmentDate;
    }

    public Long getStartingKm() { return startingKm; }

    public void setStartingKm(Long startingKm) { this.startingKm = startingKm; }

    public Long getFinishingKm() { return finishingKm; }

    public void setFinishingKm(Long finishingKm) { this.finishingKm = finishingKm; }

    public String getStartingPlace() {
        return startingPlace;
    }

    public void setStartingPlace(String startingPlace) {
        this.startingPlace = startingPlace;
    }

    public String getFinishingPlace() {
        return finishingPlace;
    }

    public void setFinishingPlace(String finishingPlace) {
        this.finishingPlace = finishingPlace;
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

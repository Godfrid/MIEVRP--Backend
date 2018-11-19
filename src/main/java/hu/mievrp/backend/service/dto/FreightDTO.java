package hu.mievrp.backend.service.dto;

import java.util.ArrayList;
import java.util.List;

public class FreightDTO {
    private Long id;

    private String startingDate;

    private String finishingDate;

    private String fulfilmentDate;

    private Long startingKm;

    private Long finishingKm;

    private String startingPlace;

    private String finishingPlace;

    private List<Long> invoiceIds = new ArrayList<>();

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

    public String getFinishingDate() { return finishingDate; }

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

    public void setStartingKm(Long startingKm) {
        this.startingKm = startingKm;
    }

    public Long getFinishingKm() {
        return finishingKm;
    }

    public void setFinishingKm(Long finishingKm) {
        this.finishingKm = finishingKm;
    }

    public String getStartingPlace() { return startingPlace; }

    public void setStartingPlace(String startingPlace) {
        this.startingPlace = startingPlace;
    }

    public String getFinishingPlace() {
        return finishingPlace;
    }

    public void setFinishingPlace(String finishingPlace) {
        this.finishingPlace = finishingPlace;
    }

    public List<Long> getInvoiceIds() {
        return invoiceIds;
    }

    public void setInvoiceIds(List<Long> invoiceIds) {
        this.invoiceIds = invoiceIds;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

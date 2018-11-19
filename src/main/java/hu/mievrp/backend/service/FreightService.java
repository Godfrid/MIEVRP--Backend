package hu.mievrp.backend.service;

import hu.mievrp.backend.model.Freight;
import hu.mievrp.backend.model.Invoice;
import hu.mievrp.backend.repository.FreightRepository;
import hu.mievrp.backend.service.dto.FreightDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FreightService {


    @Autowired
    InvoiceService invoiceService;

    private final FreightRepository freightRepository;

    public FreightService(FreightRepository freightRepository) {
        this.freightRepository = freightRepository;
    }

    @Transactional (readOnly = true)
    public FreightDTO findOne(Long id) {
        return freightRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Transactional
    public List<FreightDTO> findAll() {
        return toDto(freightRepository.findAll());
    }

    @Transactional
    public Freight findOneDirect(Long id) {
        return freightRepository.findById(id).orElse(null);
    }

    public FreightDTO save(FreightDTO freightDTO) {
        return toDto(freightRepository.save(toEntity(freightDTO)));
    }

    public void delete(Long id) { freightRepository.deleteById(id);}

    public FreightDTO toDto(Freight freight) {
        if (freight == null) return null;

        FreightDTO freightDTO = new FreightDTO();

        freightDTO.setId(freight.getId());
        freightDTO.setStartingDate(freight.getStartingDate());
        freightDTO.setFinishingDate(freight.getFinishingDate());
        freightDTO.setFulfilmentDate(freight.getFulfilmentDate());
        freightDTO.setStartingKm(freight.getStartingKm());
        freightDTO.setFinishingKm(freight.getFinishingKm());
        freightDTO.setStartingPlace(freight.getStartingPlace());
        freightDTO.setFinishingPlace(freight.getFinishingPlace());
        freightDTO.setInvoiceIds(freight.getInvoices()
                .stream().map(Invoice::getId)
                .collect(Collectors.toList()));
        freightDTO.setComment(freight.getComment());

        return freightDTO;

    }

    public List<FreightDTO> toDto(List<Freight> freights) {
        return freights.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Freight toEntity(FreightDTO freightDTO) {
        if (freightDTO == null) return null;

        Freight freight = new Freight();

        freight.setId(freightDTO.getId());
        freight.setStartingDate(freightDTO.getStartingDate());
        freight.setFinishingDate(freightDTO.getFinishingDate());
        freight.setFulfilmentDate(freightDTO.getFulfilmentDate());
        freight.setStartingKm(freightDTO.getStartingKm());
        freight.setFinishingKm(freightDTO.getFinishingKm());
        freight.setStartingPlace(freightDTO.getFinishingPlace());
        freight.setInvoices(freightDTO.getInvoiceIds()
                .stream().map(invoiceId -> invoiceService.findOneDirect(invoiceId))
                .collect(Collectors.toList()));
        freight.setComment(freightDTO.getComment());

        return freight;

    }

}
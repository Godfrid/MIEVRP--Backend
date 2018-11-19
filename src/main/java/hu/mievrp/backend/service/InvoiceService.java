package hu.mievrp.backend.service;

import hu.mievrp.backend.model.Freight;
import hu.mievrp.backend.model.Invoice;
import hu.mievrp.backend.model.Partner;
import hu.mievrp.backend.repository.InvoiceRepository;
import hu.mievrp.backend.service.dto.InvoiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceService {

    @Autowired
    FreightService freightService;

    @Autowired
    PartnerService partnerService;

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional(readOnly = true)
    public InvoiceDTO findOne(Long id) {
        return invoiceRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<InvoiceDTO> findAll() {
        return toDto(invoiceRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Invoice findOneDirect(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }


    public InvoiceDTO toDto(Invoice invoice) {
        if (invoice == null) return null;

        InvoiceDTO invoiceDTO = new InvoiceDTO();

        invoiceDTO.setId(invoice.getId());
        invoiceDTO.setNetCost(invoice.getNetCost());
        invoiceDTO.setGrossCost(invoice.getGrossCost());
        invoiceDTO.setVAT(invoice.getVAT());
        invoiceDTO.setCurrency(invoice.getCurrency());
        invoiceDTO.setDate(invoice.getDate());
        invoiceDTO.setFulfilmentDate(invoice.getFulfilmentDate());
        invoiceDTO.setPartnerId(Optional.ofNullable(invoice.getPartner())
                    .map(Partner::getId).orElse(null));
        invoiceDTO.setFreightIds(invoice.getFreights()
                    .stream().map(Freight::getId)
                    .collect(Collectors.toList()));

        return invoiceDTO;
    }

    public List<InvoiceDTO> toDto(List<Invoice> invoices) {
        return invoices.stream().map(this::toDto).collect(Collectors.toList());

    }

    public Invoice toEntity(InvoiceDTO invoiceDTO) {

        Invoice invoice = new Invoice();

        invoice.setId(invoiceDTO.getId());
        invoice.setNetCost(invoiceDTO.getNetCost());
        invoice.setGrossCost(invoiceDTO.getGrossCost());
        invoice.setVAT(invoiceDTO.getVAT());
        invoice.setCurrency(invoiceDTO.getCurrency());
        invoice.setDate(invoiceDTO.getDate());
        invoice.setFulfilmentDate(invoiceDTO.getFulfilmentDate());
        invoice.setPartner(partnerService.findOneDirect(invoiceDTO.getPartnerId()));
        invoice.setFreights(invoiceDTO.getFreightIds()
                .stream().map(freightId -> freightService.findOneDirect(freightId))
                .collect(Collectors.toList()));

        return invoice;
    }

}

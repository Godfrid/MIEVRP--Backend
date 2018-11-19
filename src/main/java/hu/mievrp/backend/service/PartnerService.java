package hu.mievrp.backend.service;

import hu.mievrp.backend.model.Invoice;
import hu.mievrp.backend.model.Location;
import hu.mievrp.backend.model.Partner;
import hu.mievrp.backend.repository.PartnerRepository;
import hu.mievrp.backend.service.dto.PartnerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PartnerService {

    @Autowired
    private LocationService locationService;

    @Autowired
    private InvoiceService invoiceService;

    private final PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) { this.partnerRepository = partnerRepository; }

    @Transactional(readOnly = true)
    public PartnerDTO findOne(Long id) { return partnerRepository.findById(id).map(this::toDto).orElse(null); }

    @Transactional(readOnly = true)
    public List<PartnerDTO> findAll() { return toDto(partnerRepository.findAll()); }

    @Transactional(readOnly = true)
    public Partner findOneDirect(Long id) { return partnerRepository.findById(id).orElse(null); }

    public PartnerDTO save(PartnerDTO partnerDto) { return toDto(partnerRepository.save(toEntity(partnerDto))); }

    public void delete(Long id) { partnerRepository.deleteById(id);}


    public PartnerDTO toDto(Partner partner) {
        if (partner == null) return null;

        PartnerDTO partnerDTO = new PartnerDTO();

        partnerDTO.setId(partner.getId());
        partnerDTO.setName(partner.getName());
        partnerDTO.setEmail(partner.getEmail());
        partnerDTO.setPhone(partner.getPhone());
        partnerDTO.setLocationIds(partner.getLocations()
                    .stream().map(Location::getId)
                    .collect(Collectors.toList()));
        partnerDTO.setInvoiceIds(partner.getInvoices()
                .stream().map(Invoice::getId)
                .collect(Collectors.toList()));

        return partnerDTO;
    }

    public List<PartnerDTO> toDto(List<Partner> partners) {

        return partners.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Partner toEntity(PartnerDTO partnerDTO) {
        if (partnerDTO == null) return null;

        Partner partner = new Partner();

        partner.setId(partnerDTO.getId());
        partner.setName(partnerDTO.getName());
        partner.setPhone(partnerDTO.getPhone());
        partner.setEmail(partnerDTO.getEmail());
        partner.setLocations(partnerDTO.getLocationIds()
                .stream().map(locationId -> locationService.findOneDirect(locationId))
                .collect(Collectors.toList()));
        partner.setInvoices(partnerDTO.getInvoiceIds()
                .stream().map(invoiceId -> invoiceService.findOneDirect(invoiceId))
                .collect(Collectors.toList()));

        return partner;
    }

}

package hu.mievrp.backend.service;

import hu.mievrp.backend.model.Partner;
import hu.mievrp.backend.repository.PartnerRepository;
import hu.mievrp.backend.service.dto.PartnerDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class PartnerService {

    private final PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) { this.partnerRepository = partnerRepository; }

    @Transactional(readOnly = true)
    public PartnerDTO findOne(Long id) { return partnerRepository.findById(id).map(this::toDto).orElse(null); }

    @Transactional(readOnly = true)
    public List<PartnerDTO> findAll() { return toDto(partnerRepository.findAll()); }

    public PartnerDTO save(PartnerDTO partnerDto) { return toDto(partnerRepository.save(toEntity(partnerDto))); }

    public void delete(Long id) { partnerRepository.deleteById(id);}


    public PartnerDTO toDto(Partner partner) {
        if (partner == null) return null;

        PartnerDTO partnerDTO = new PartnerDTO();

        partnerDTO.setId(partner.getId());
        partnerDTO.setName(partner.getName());
        partnerDTO.setEmail(partner.getEmail());
        partnerDTO.setPhone(partner.getPhone());
        partnerDTO.setLocation(partner.getLocation());

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
        partner.setLocation(partnerDTO.getLocation());

        return partner;
    }

}

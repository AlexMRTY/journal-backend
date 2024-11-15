package com.asifshirvan.journal_backend.mappers;

import com.asifshirvan.journal_backend.dto.PractitionerDTO;
import com.asifshirvan.journal_backend.models.Practitioner;
import org.mapstruct.factory.Mappers;

public interface PractitionerMapper {
    PractitionerMapper INSTANCE = Mappers.getMapper(PractitionerMapper.class);

    PractitionerDTO practitionerToPractitionerDTO(Practitioner practitioner);
    Practitioner practitionerDTOToPractitioner(PractitionerDTO practitionerDTO);
}

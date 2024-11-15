package com.asifshirvan.journal_backend.mappers;

import com.asifshirvan.journal_backend.dto.PatientDTO;
import com.asifshirvan.journal_backend.models.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientDTO patientToPatientDTO(Patient patient);
    Patient patientDTOToPatient(PatientDTO patientDTO);
}

package com.asifshirvan.journal_backend.models;

import com.asifshirvan.journal_backend.enums.LaboratoryUnits;
import com.asifshirvan.journal_backend.enums.PhysicalExamUnits;
import com.asifshirvan.journal_backend.enums.VitalSignsUnits;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UnitConverter implements AttributeConverter<Unit, String> {

    @Override
    public String convertToDatabaseColumn(Unit attribute) {
        return attribute == null ? null : attribute.name();
    }

    @Override
    public Unit convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            return VitalSignsUnits.valueOf(dbData);
        } catch (IllegalArgumentException e) {
            // Not a VitalSignsUnits, try the next enum
        }
        try {
            return PhysicalExamUnits.valueOf(dbData);
        } catch (IllegalArgumentException e) {
            // Not a PhysicalExamUnits, try the next enum
        }
        try {
            return LaboratoryUnits.valueOf(dbData);
        } catch (IllegalArgumentException e) {
            // Not a LaboratoryUnits, handle the error or add more enums if needed
        }
        throw new IllegalArgumentException("Unknown enum type for dbData: " + dbData);
    }
}

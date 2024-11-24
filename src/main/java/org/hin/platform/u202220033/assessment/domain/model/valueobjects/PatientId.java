package org.hin.platform.u202220033.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PatientId(Long patientId) {
    public PatientId {
        if (patientId == null) {
            throw new IllegalArgumentException("Patient ID cannot be null");
        }
    }
    public PatientId() {
        this(0L);
    }

}

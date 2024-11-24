package org.hin.platform.u202220033.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record ExaminerNationalProviderIdentifier(UUID examinerNationalProviderIdentifier) {
    public ExaminerNationalProviderIdentifier {
        if (examinerNationalProviderIdentifier == null) {
            throw new IllegalArgumentException("Examiner national provider identifier cannot be null");
        }
        if(examinerNationalProviderIdentifier.toString().length() != 36) {
            throw new IllegalArgumentException("Examiner national provider identifier must be a valid UUID");
        }
    }
}

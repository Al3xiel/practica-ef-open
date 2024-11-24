package org.hin.platform.u202220033.personnel.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record NationalProviderIdentifier(UUID nationalProviderIdentifier) {
    public NationalProviderIdentifier {
        if (nationalProviderIdentifier == null) {
            throw new IllegalArgumentException("National provider identifier cannot be null");
        }
        if(nationalProviderIdentifier.toString().length() != 36) {
            throw new IllegalArgumentException("National provider identifier must be a valid UUID");
        }
    }
}

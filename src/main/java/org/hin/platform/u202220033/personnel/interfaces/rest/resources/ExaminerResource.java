package org.hin.platform.u202220033.personnel.interfaces.rest.resources;

public record ExaminerResource(
        Long id,
        String firstName,
        String lastName,
        String nationalProviderIdentifier
) {
}

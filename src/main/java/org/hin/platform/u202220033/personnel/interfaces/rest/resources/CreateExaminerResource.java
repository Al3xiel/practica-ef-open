package org.hin.platform.u202220033.personnel.interfaces.rest.resources;

public record CreateExaminerResource(
        String firstName,
        String lastName,
        String nationalProviderIdentifier) {
}

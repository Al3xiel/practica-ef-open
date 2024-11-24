package org.hin.platform.u202220033.assessment.domain.model.commands;

public record CreateMentalStateExamCommand(String examDate, String examinerNationalProviderIdentifier, String patientNationalProviderIdentifier) {
}

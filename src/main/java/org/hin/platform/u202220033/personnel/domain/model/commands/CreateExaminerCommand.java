package org.hin.platform.u202220033.personnel.domain.model.commands;

public record CreateExaminerCommand(String firstName, String lastName, String nationalProviderIdentifier, Long patientId, Integer orientationScore, Integer registrationScore, Integer attentionAndCalculationScore, Integer recallScore, Integer languageScore) {
}

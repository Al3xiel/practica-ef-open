package org.hin.platform.u202220033.assessment.interfaces.rest.resources;

public record CreateMentalStateExamResource(Long patientId, String examinerNationalProviderIdentifier, String examDate, Integer orientationScore, Integer registrationScore, Integer attentionAndCalculationScore, Integer recallScore, Integer languageScore) {
}

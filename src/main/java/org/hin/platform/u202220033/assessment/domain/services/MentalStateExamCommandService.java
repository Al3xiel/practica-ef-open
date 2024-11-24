package org.hin.platform.u202220033.assessment.domain.services;

import org.hin.platform.u202220033.assessment.domain.model.aggregates.MentalStateExam;
import org.hin.platform.u202220033.assessment.domain.model.commands.CreateMentalStateExamCommand;

import java.util.Optional;

public interface MentalStateExamCommandService {
    Optional<MentalStateExam> handle(CreateMentalStateExamCommand command);
}

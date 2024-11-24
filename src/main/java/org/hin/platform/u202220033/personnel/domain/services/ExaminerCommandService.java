package org.hin.platform.u202220033.personnel.domain.services;

import org.hin.platform.u202220033.personnel.domain.model.aggregates.Examiner;
import org.hin.platform.u202220033.personnel.domain.model.commands.CreateExaminerCommand;

import java.util.Optional;

public interface ExaminerCommandService {
    Optional<Examiner> handle(CreateExaminerCommand command);
}

package org.hin.platform.u202220033.personnel.domain.services;

import org.hin.platform.u202220033.personnel.domain.model.aggregates.Examiner;
import org.hin.platform.u202220033.personnel.domain.model.queries.GetExaminerByNationalProviderIdentifier;

import java.util.Optional;

public interface ExaminerQueryService {
    Optional<Examiner> handle(GetExaminerByNationalProviderIdentifier query);
}

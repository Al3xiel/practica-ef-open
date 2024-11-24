package org.hin.platform.u202220033.personnel.interfaces.acl;

import org.hin.platform.u202220033.personnel.domain.model.aggregates.Examiner;

import java.util.Optional;

public interface ExaminerContextFacade {
    boolean examinerExists(String nationalProviderIdentifier);
    Optional<Examiner> getExaminerByNationalProviderIdentifier(String nationalProviderIdentifier);
}

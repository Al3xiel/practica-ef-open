package org.hin.platform.u202220033.assessment.application.outboundServices.acl;

import org.hin.platform.u202220033.personnel.domain.model.aggregates.Examiner;
import org.hin.platform.u202220033.personnel.interfaces.acl.ExaminerContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalExaminerService{
    private final ExaminerContextFacade examinerContextFacade;

    public ExternalExaminerService(ExaminerContextFacade examinerContextFacade) {
        this.examinerContextFacade = examinerContextFacade;
    }

    public boolean examinerExists(String nationalProviderIdentifier) {
        return examinerContextFacade.examinerExists(nationalProviderIdentifier);
    }

    public Optional<Examiner> getExaminerByNationalProviderIdentifier(String nationalProviderIdentifier) {
        return examinerContextFacade.getExaminerByNationalProviderIdentifier(nationalProviderIdentifier);
    }
}

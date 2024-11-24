package org.hin.platform.u202220033.assessment.application.outboundServices.acl;

import org.hin.platform.u202220033.personnel.interfaces.acl.ExaminerContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalExaminerService{
    private final ExaminerContextFacade examinerContextFacade;

    public ExternalExaminerService(ExaminerContextFacade examinerContextFacade) {
        this.examinerContextFacade = examinerContextFacade;
    }

    public boolean examinerExists(String nationalProviderIdentifier) {
        return examinerContextFacade.examinerExists(nationalProviderIdentifier);
    }
}

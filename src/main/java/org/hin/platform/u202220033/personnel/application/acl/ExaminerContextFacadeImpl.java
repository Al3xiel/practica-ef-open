package org.hin.platform.u202220033.personnel.application.acl;

import org.hin.platform.u202220033.personnel.domain.model.aggregates.Examiner;
import org.hin.platform.u202220033.personnel.domain.model.queries.GetExaminerByNationalProviderIdentifier;
import org.hin.platform.u202220033.personnel.domain.services.ExaminerQueryService;
import org.hin.platform.u202220033.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.hin.platform.u202220033.personnel.interfaces.acl.ExaminerContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExaminerContextFacadeImpl implements ExaminerContextFacade {
    private final ExaminerQueryService examinerQueryService;

    public ExaminerContextFacadeImpl(ExaminerQueryService examinerQueryService) {
        this.examinerQueryService = examinerQueryService;
    }

    @Override
    public boolean examinerExists(String nationalProviderIdentifier) {
        var getExaminerByNationalProviderIdentifier = new GetExaminerByNationalProviderIdentifier(nationalProviderIdentifier);
        var examiner = examinerQueryService.handle(getExaminerByNationalProviderIdentifier);
        return examiner.isPresent();
    }

    @Override
    public Optional<Examiner> getExaminerByNationalProviderIdentifier(String nationalProviderIdentifier) {
        var getExaminerByNationalProviderIdentifier = new GetExaminerByNationalProviderIdentifier(nationalProviderIdentifier);
        var examiner = examinerQueryService.handle(getExaminerByNationalProviderIdentifier);
        return Optional.of(examiner.get());
    }
}

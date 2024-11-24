package org.hin.platform.u202220033.personnel.application;

import org.hin.platform.u202220033.personnel.domain.model.aggregates.Examiner;
import org.hin.platform.u202220033.personnel.domain.model.queries.GetExaminerByNationalProviderIdentifier;
import org.hin.platform.u202220033.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hin.platform.u202220033.personnel.domain.services.ExaminerQueryService;
import org.hin.platform.u202220033.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExaminerQueryServiceImpl implements ExaminerQueryService{

    private final ExaminerRepository examinerRepository;

    public ExaminerQueryServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    @Override
    public Optional<Examiner> handle(GetExaminerByNationalProviderIdentifier query) {
        var nationalProviderIdentifier = new NationalProviderIdentifier(UUID.fromString(query.nationalProviderIdentifier()));
        return this.examinerRepository.findByNationalProviderIdentifier(nationalProviderIdentifier);
    }
}

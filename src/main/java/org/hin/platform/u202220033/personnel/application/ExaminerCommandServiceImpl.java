package org.hin.platform.u202220033.personnel.application;

import org.hin.platform.u202220033.personnel.domain.model.aggregates.Examiner;
import org.hin.platform.u202220033.personnel.domain.model.commands.CreateExaminerCommand;
import org.hin.platform.u202220033.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hin.platform.u202220033.personnel.domain.services.ExaminerCommandService;
import org.hin.platform.u202220033.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExaminerCommandServiceImpl implements ExaminerCommandService {

    private final ExaminerRepository examinerRepository;

    public ExaminerCommandServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    @Override
    public Optional<Examiner> handle(CreateExaminerCommand command) {
        var nationalProviderIdentifier = new NationalProviderIdentifier(UUID.fromString(command.nationalProviderIdentifier()));
        var examinerInDatabase = this.examinerRepository.findByNationalProviderIdentifier(nationalProviderIdentifier);
        if (examinerInDatabase.isPresent()) throw new IllegalArgumentException("An examiner with the national provider identifier already exists");

        var examiner = new Examiner(command);
        var createdExaminer = examinerRepository.save(examiner);
        return Optional.of(createdExaminer);
    }
}

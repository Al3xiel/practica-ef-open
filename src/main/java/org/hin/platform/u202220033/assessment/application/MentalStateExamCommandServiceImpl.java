package org.hin.platform.u202220033.assessment.application;

import org.hin.platform.u202220033.assessment.application.outboundServices.acl.ExternalExaminerService;
import org.hin.platform.u202220033.assessment.domain.model.aggregates.MentalStateExam;
import org.hin.platform.u202220033.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hin.platform.u202220033.assessment.domain.services.MentalStateExamCommandService;
import org.hin.platform.u202220033.assessment.infrastructure.persistence.jpa.repositories.MentalStateExamRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Service
public class MentalStateExamCommandServiceImpl implements MentalStateExamCommandService {
    private final ExternalExaminerService externalExaminerService;
    private final MentalStateExamRepository mentalStateExamRepository;

    public MentalStateExamCommandServiceImpl(ExternalExaminerService externalExaminerService, MentalStateExamRepository mentalStateExamRepository) {
        this.externalExaminerService = externalExaminerService;
        this.mentalStateExamRepository = mentalStateExamRepository;
    }

    @Override
    public Optional<MentalStateExam> handle(CreateMentalStateExamCommand command) {
        var examinerNationalProviderIdentifier = command.examinerNationalProviderIdentifier();
        if(!externalExaminerService.examinerExists(examinerNationalProviderIdentifier)) {
            throw new IllegalArgumentException("Examiner does not exist");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate examDate = LocalDate.parse(command.examDate(), formatter);
        if (examDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Exam date cannot be in the future");
        }
        var orientationScore = command.orientationScore();
        if(orientationScore<0 || orientationScore>10) {
            throw new IllegalArgumentException("Orientation score must be between 0 and 10");
        }
        var registrationScore = command.registrationScore();
        if(registrationScore<0 || registrationScore>3) {
            throw new IllegalArgumentException("Registration score must be between 0 and 3");
        }
        var attentionAndCalculationScore = command.attentionAndCalculationScore();
        if(attentionAndCalculationScore<0 || attentionAndCalculationScore>5) {
            throw new IllegalArgumentException("Attention and calculation score must be between 0 and 5");
        }
        var recallScore = command.recallScore();
        if(recallScore<0 || recallScore>3) {
            throw new IllegalArgumentException("Recall score must be between 0 and 3");
        }
        var languageScore = command.languageScore();
        if(languageScore<0 || languageScore>9) {
            throw new IllegalArgumentException("Language score must be between 0 and 9");
        }
        var mentalStateExam = new MentalStateExam(command);
        var owner = externalExaminerService.getExaminerByNationalProviderIdentifier(examinerNationalProviderIdentifier);
        mentalStateExam.setExaminer(owner.get());
        var createdMentalStateExam = mentalStateExamRepository.save(mentalStateExam);
        return Optional.of(createdMentalStateExam);
    }
}

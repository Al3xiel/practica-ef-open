package org.hin.platform.u202220033.assessment.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hin.platform.u202220033.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hin.platform.u202220033.assessment.domain.model.valueobjects.ExaminerNationalProviderIdentifier;
import org.hin.platform.u202220033.personnel.domain.model.aggregates.Examiner;
import org.hin.platform.u202220033.personnel.domain.model.commands.CreateExaminerCommand;
import org.hin.platform.u202220033.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
public class MentalStateExam extends AuditableAbstractAggregateRoot<MentalStateExam> {
    @NonNull
    private Long patientId;
    @NonNull
    @Embedded
    private ExaminerNationalProviderIdentifier examinerNationalProviderIdentifier;
    @NonNull
    private LocalDate examDate;
    @NonNull
    private Integer orientationScore;
    @NonNull
    private Integer registrationScore;
    @NonNull
    private Integer attentionAndCalculationScore;
    @NonNull
    private Integer recallScore;
    @NonNull
    private Integer languageScore;

    @Setter
    @ManyToOne
    @JoinColumn(name = "examiner_id", nullable = false)
    private Examiner examiner;

    public MentalStateExam() {
    }

    public MentalStateExam(CreateMentalStateExamCommand command) {
        this.patientId = command.patientId();
        this.examinerNationalProviderIdentifier = new ExaminerNationalProviderIdentifier(UUID.fromString(command.examinerNationalProviderIdentifier()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.examDate = LocalDate.parse(command.examDate(), formatter);
        this.orientationScore = command.orientationScore();
        this.registrationScore = command.registrationScore();
        this.attentionAndCalculationScore = command.attentionAndCalculationScore();
        this.recallScore = command.recallScore();
        this.languageScore = command.languageScore();
    }
}

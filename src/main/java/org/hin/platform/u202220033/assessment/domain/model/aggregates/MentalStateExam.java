package org.hin.platform.u202220033.assessment.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NonNull;
import org.hin.platform.u202220033.assessment.domain.model.valueobjects.ExaminerNationalProviderIdentifier;
import org.hin.platform.u202220033.assessment.domain.model.valueobjects.PatientId;
import org.hin.platform.u202220033.personnel.domain.model.aggregates.Examiner;
import org.hin.platform.u202220033.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.Date;

public class MentalStateExam extends AuditableAbstractAggregateRoot<MentalStateExam> {
    @NonNull
    @Embedded
    private PatientId patientId;
    @NonNull
    @Embedded
    private ExaminerNationalProviderIdentifier examinerNationalProviderIdentifier;
    @NonNull
    private Date examDate;
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

    @ManyToOne
    @JoinColumn(name = "examiner_id", nullable = false)
    private Examiner examiner;
}

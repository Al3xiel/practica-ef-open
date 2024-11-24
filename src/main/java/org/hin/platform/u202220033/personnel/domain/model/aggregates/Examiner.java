package org.hin.platform.u202220033.personnel.domain.model.aggregates;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.NonNull;
import org.hin.platform.u202220033.assessment.domain.model.aggregates.MentalStateExam;
import org.hin.platform.u202220033.personnel.domain.model.commands.CreateExaminerCommand;
import org.hin.platform.u202220033.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hin.platform.u202220033.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.List;
import java.util.UUID;

@Entity
public class Examiner extends AuditableAbstractAggregateRoot<Examiner> {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @Embedded
    private NationalProviderIdentifier nationalProviderIdentifier;
    @OneToMany(mappedBy = "examiner", cascade = CascadeType.ALL, orphanRemoval = true)
    List<MentalStateExam> mentalStateExams;

    public Examiner() {
    }

    public Examiner(CreateExaminerCommand command) {
        this.firstName = command.firstName();
        this.lastName = command.lastName();
        var commandNationalProviderIdentifier = UUID.fromString(command.nationalProviderIdentifier());
        this.nationalProviderIdentifier = new NationalProviderIdentifier(commandNationalProviderIdentifier);
    }
}

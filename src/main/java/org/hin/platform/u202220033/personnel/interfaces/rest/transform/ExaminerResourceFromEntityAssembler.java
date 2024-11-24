package org.hin.platform.u202220033.personnel.interfaces.rest.transform;

import org.hin.platform.u202220033.personnel.domain.model.aggregates.Examiner;
import org.hin.platform.u202220033.personnel.interfaces.rest.resources.ExaminerResource;

public class ExaminerResourceFromEntityAssembler {
    public static ExaminerResource toResourceFromEntity(Examiner entity) {
        return new ExaminerResource(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getNationalProviderIdentifier().nationalProviderIdentifier().toString()
        );
    }
}

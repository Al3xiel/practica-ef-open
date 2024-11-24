package org.hin.platform.u202220033.personnel.interfaces.rest.transform;

import org.hin.platform.u202220033.personnel.domain.model.commands.CreateExaminerCommand;
import org.hin.platform.u202220033.personnel.interfaces.rest.resources.CreateExaminerResource;

public class CreateExaminerCommandFromResourceAssembler {
    public static CreateExaminerCommand toCommandFromResource(CreateExaminerResource resource) {
        return new CreateExaminerCommand(
                resource.firstName(),
                resource.lastName(),
                resource.nationalProviderIdentifier()
        );
    }
}

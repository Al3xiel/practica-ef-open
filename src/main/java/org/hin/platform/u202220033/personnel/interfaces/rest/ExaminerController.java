package org.hin.platform.u202220033.personnel.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hin.platform.u202220033.personnel.domain.services.ExaminerCommandService;
import org.hin.platform.u202220033.personnel.interfaces.rest.resources.CreateExaminerResource;
import org.hin.platform.u202220033.personnel.interfaces.rest.resources.ExaminerResource;
import org.hin.platform.u202220033.personnel.interfaces.rest.transform.CreateExaminerCommandFromResourceAssembler;
import org.hin.platform.u202220033.personnel.interfaces.rest.transform.ExaminerResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/examiners")
@Tag(name = "Examiner", description = "Examiner Endpoints")
@ApiResponse(responseCode = "201", description = "Examiner Created")
public class ExaminerController {
    private final ExaminerCommandService examinerCommandService;

    public ExaminerController(ExaminerCommandService examinerCommandService) {
        this.examinerCommandService = examinerCommandService;
    }

    @PostMapping
    @Operation(summary = "Create an Examiner", description = "Create an Examiner")
    public ResponseEntity<ExaminerResource> createExaminer(@RequestBody CreateExaminerResource resource){
        var createExaminerCommand = CreateExaminerCommandFromResourceAssembler.toCommandFromResource(resource);
        var examiner = examinerCommandService.handle(createExaminerCommand);

        if(examiner.isEmpty()) return ResponseEntity.badRequest().build();

        var examinerResource = ExaminerResourceFromEntityAssembler.toResourceFromEntity(examiner.get());

        return new ResponseEntity<>(examinerResource, HttpStatus.valueOf(201));
    }
}

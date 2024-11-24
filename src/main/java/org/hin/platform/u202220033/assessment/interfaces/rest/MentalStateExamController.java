package org.hin.platform.u202220033.assessment.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hin.platform.u202220033.assessment.application.MentalStateExamCommandServiceImpl;
import org.hin.platform.u202220033.assessment.domain.model.aggregates.MentalStateExam;
import org.hin.platform.u202220033.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hin.platform.u202220033.assessment.domain.services.MentalStateExamCommandService;
import org.hin.platform.u202220033.assessment.interfaces.rest.resources.CreateMentalStateExamResource;
import org.hin.platform.u202220033.assessment.interfaces.rest.resources.MentalStateExamResource;
import org.hin.platform.u202220033.assessment.interfaces.rest.transform.CreateMentalStateExamCommandFromResourceAssembler;
import org.hin.platform.u202220033.assessment.interfaces.rest.transform.MentalStateExamResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/mental-state-exams")
@Tag(name = "Mental State Exam", description = "Mental State Exam Endpoints")
@ApiResponse(responseCode = "201", description = "Mental State Exam Created")
public class MentalStateExamController {
    private final MentalStateExamCommandService mentalStateExamCommandService;

    public MentalStateExamController(MentalStateExamCommandService mentalStateExamCommandService) {
        this.mentalStateExamCommandService = mentalStateExamCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a mental state exam", description = "Create a mental state exam")
    public ResponseEntity<MentalStateExamResource> createMentalStateExam(@RequestBody CreateMentalStateExamResource resource) {
        var createMentalStateExamCommand = CreateMentalStateExamCommandFromResourceAssembler.toCommandFromResource(resource);
        var mentalStateExam = mentalStateExamCommandService.handle(createMentalStateExamCommand);

        if(mentalStateExam.isEmpty()) return ResponseEntity.badRequest().build();

        var mentalStateExamResource = MentalStateExamResourceFromEntityAssembler.toResourceFromEntity(mentalStateExam.get());

        return new ResponseEntity<>(mentalStateExamResource, HttpStatus.valueOf(201));
    }
}

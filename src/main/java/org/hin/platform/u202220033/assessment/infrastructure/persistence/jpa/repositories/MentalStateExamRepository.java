package org.hin.platform.u202220033.assessment.infrastructure.persistence.jpa.repositories;

import org.hin.platform.u202220033.assessment.domain.model.aggregates.MentalStateExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentalStateExamRepository extends JpaRepository<MentalStateExam, Long> {
}

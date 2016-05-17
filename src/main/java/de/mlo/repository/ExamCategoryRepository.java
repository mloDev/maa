package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.examCategory;

public interface ExamCategoryRepository extends JpaRepository<examCategory, Integer>{

}

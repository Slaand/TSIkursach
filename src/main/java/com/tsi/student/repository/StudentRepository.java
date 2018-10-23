package com.tsi.student.repository;
import org.springframework.data.repository.CrudRepository;

import com.tsi.student.entity.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Transactional
    List<Student> findAll();

}

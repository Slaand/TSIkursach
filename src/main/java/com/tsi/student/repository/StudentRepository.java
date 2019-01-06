package com.tsi.student.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tsi.student.entity.Student;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Transactional
    List<Student> findAll();

    @Query("select s from Student s where s.id = :id")
    List<Student> findStudentByID(@Param("id") int id);

    @Query("select s from Student s where s.surname = :surname")
    List<Student> findStudentBySurname(@Param("surname") String surname);

    @Query("select s from Student s where s.city = :city")
    List<Student> findStudentByCity(@Param("city") String city);

    @Query("select s from Student s where s.faculty = :faculty")
    List<Student> findStudentByFac(@Param("faculty") String faculty);

    @Query("select s from Student s where s.name = :name")
    List<Student> findStudentByName(@Param("name") String name);

    @Query("select s from Student s where s.country = :country")
    List<Student> findStudentByCountry(@Param("country") String country);

    @Query("select s from Student s where s.personalCode = :personalCode")
    List<Student> findStudentByPersonalCode(@Param("personalCode") String personalCode);

    @Query("select s from Student s where s.group = :group")
    List<Student> findStudentByGroup(@Param("group") String group);
}

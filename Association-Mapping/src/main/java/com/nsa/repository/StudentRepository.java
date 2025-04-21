package com.nsa.repository;

import com.nsa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}

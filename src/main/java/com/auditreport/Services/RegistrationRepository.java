package com.auditreport.Services;

import com.auditreport.Model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationRepository extends JpaRepository<Student, Integer> {

    @Bean
    public Student save(Student student);



}

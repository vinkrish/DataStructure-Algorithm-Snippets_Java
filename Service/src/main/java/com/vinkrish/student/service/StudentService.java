package com.vinkrish.student.service;

import java.util.Map;
import com.vinkrish.student.model.Student;

public interface StudentService {

    public String create(Student student);

    public Student findById(String registrationId);

    public Student update(Student student);

    public Student delete(String registrationId);
    
    public Map<String, Student> findAll();
}
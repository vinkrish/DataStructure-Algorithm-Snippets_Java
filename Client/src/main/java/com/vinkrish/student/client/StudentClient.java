package com.vinkrish.student.client;

import java.util.Map;
import com.vinkrish.student.model.Student;
import com.vinkrish.student.service.StudentService;
import com.vinkrish.student.service.dbimpl.StudentDbService;

public class StudentClient {

    public static void main(String[] args) {
        StudentService service = new StudentDbService();
        Student student = new Student("1234abcd");
        service.create(student);
        
        Student studentFound = service.findById("1234abcd");
        System.out.println(studentFound.getRegistrationId());
        
        student.setRegistrationId("abcd1234");
        service.update(student);
        
        service.delete("1234abcd");
        
        Map<String, Student> studentList = service.findAll();
        System.out.println(studentList.size());
        
        studentFound = service.findById("abcd1234");
        System.out.println(studentFound.getRegistrationId());
        
        service.delete("abcd1234");
        
        studentList = service.findAll();
        System.out.println(studentList.size());
    }
}

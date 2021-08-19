package com.vinkrish.student.service.dbimpl;

import com.vinkrish.student.service.StudentService;
import com.vinkrish.student.model.Student;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

public class StudentDbService implements StudentService {

    private static Logger logger = Logger.getLogger("StudentDbService");
    
    private Map<String, Student> studentMap = new HashMap<String, Student>();

    public String create(Student student) {
        logger.log(Level.INFO, "Creating student in DB...");
        studentMap.put(student.getRegistrationId(), student);
        return student.getRegistrationId();
    }

    public Student findById(String registrationId) {
        logger.log(Level.INFO, "Reading student from DB...");
        return studentMap.get(registrationId);
    }

    public Student update(Student student) {
        logger.log(Level.INFO, "Updating student in DB...");
        return studentMap.put(student.getRegistrationId(), student);
    }

    public Student delete(String registrationId) {
        logger.log(Level.INFO, "Deleting student in DB...");
        return studentMap.remove(registrationId);
    }

	@Override
	public Map<String, Student> findAll()
	{
		logger.log(Level.INFO, "Reading students from DB...");
		return studentMap;
	}
}
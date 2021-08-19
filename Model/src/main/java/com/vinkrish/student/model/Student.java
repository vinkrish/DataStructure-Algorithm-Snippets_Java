package com.vinkrish.student.model;

public class Student {
    private String registrationId;
    
    public Student(String registrationId) {
    	this.registrationId = registrationId;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
}
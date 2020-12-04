package com.example.lab1;

public class GetterSetter {
    String id;
    String name;
    String number;
    String school;
    String level;
    String program;
    String validity;

    String student;

    public GetterSetter(String id, String name, String number, String school, String level, String program, String validity, String student) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.school = school;
        this.level = level;
        this.program = program;
        this.validity = validity;
        this.student = student;
    }

    public int getId() {
        return Integer.parseInt(id);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }
}

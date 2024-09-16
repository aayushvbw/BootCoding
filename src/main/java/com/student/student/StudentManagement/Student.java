package com.student.student.StudentManagement;

public class Student {
    private Long id;
    private String name;
    private String email;
    private String dob;
    private Integer age;

    public Student(){

    }

    public Student(Long id, Integer age, String dob, String email, String name) {
        this.id = id;
        this.age = age;
        this.dob = dob;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}

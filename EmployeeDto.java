//package com.ms.cicd.dto;

public class EmployeeDto {
    private int employeeId;
    private String firstName;
    private String lastName;
    private int companyId;
    private String companyName;

    //constructors//
    public EmployeeDto () {};

    public EmployeeDto(int employeeId, String firstName,
                       String lastName, int companyId, String companyName) {

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyId = companyId;
        this.companyName = companyName;
    }

    //Getters and Setters//
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCompanyId () { return this.companyId ;}
    public void setCompanyId (int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName(){
        return this.companyName;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
}

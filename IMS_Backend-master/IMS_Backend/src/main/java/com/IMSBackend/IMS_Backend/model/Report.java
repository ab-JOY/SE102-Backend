package com.IMSBackend.IMS_Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Report {
    @Id
    @GeneratedValue
    private Long reportId;
    private String reportName;
    private String FirstName;
    private String LastName;
    private Integer Age;
    private String Address;
    private String Sex;
    private String MembershipType;

    public Long getReportId() {
        return reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public Integer getAge() {
        return Age;
    }

    public String getAddress() {
        return Address;
    }

    public String getSex() {
        return Sex;
    }

    public String getMembershipType() {
        return MembershipType;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public void setMembershipType(String membershipType) {
        MembershipType = membershipType;
    }
}

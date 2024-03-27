package com.IMSBackend.IMS_Backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class MemberTemp {
    @Id
    @GeneratedValue
    private Long id_temp;
    private String firstName_temp;
    private String middleName_temp;
    private String lastName_temp;
    private Integer age_temp;
    private String dateOfBirth_temp;
    private String sex_temp;
    private String address_temp;
    private String mobileNumber_temp;
    private String membershipType_temp;


    public void setId_temp(Long id_temp) {
        this.id_temp = id_temp;
    }

    public void setFirstName_temp(String firstName_temp) {
        this.firstName_temp = firstName_temp;
    }

    public void setMiddleName_temp(String middleName_temp) {
        this.middleName_temp = middleName_temp;
    }

    public void setLastName_temp(String lastName_temp) {
        this.lastName_temp = lastName_temp;
    }

    public void setAge_temp(Integer age_temp) {
        this.age_temp = age_temp;
    }

    public void setDateOfBirth_temp(String dateOfBirth_temp) {
        this.dateOfBirth_temp = dateOfBirth_temp;
    }

    public void setSex_temp(String sex_temp) {
        this.sex_temp = sex_temp;
    }

    public void setAddress_temp(String address_temp) {
        this.address_temp = address_temp;
    }

    public void setMobileNumber_temp(String mobileNumber_temp) {
        this.mobileNumber_temp = mobileNumber_temp;
    }

    public void setMembershipType_temp(String membershipType_temp) {
        this.membershipType_temp = membershipType_temp;
    }

    public Long getId_temp() {
        return id_temp;
    }

    public String getFirstName_temp() {
        return firstName_temp;
    }

    public String getMiddleName_temp() {
        return middleName_temp;
    }

    public String getLastName_temp() {
        return lastName_temp;
    }

    public Integer getAge_temp() {
        return age_temp;
    }

    public String getDateOfBirth_temp() {
        return dateOfBirth_temp;
    }

    public String getSex_temp() {
        return sex_temp;
    }

    public String getAddress_temp() {
        return address_temp;
    }

    public String getMobileNumber_temp() {
        return mobileNumber_temp;
    }

    public String getMembershipType_temp() {
        return membershipType_temp;
    }

}

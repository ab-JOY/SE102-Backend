package com.IMSBackend.IMS_Backend.dto;

import com.IMSBackend.IMS_Backend.model.Member;
import com.IMSBackend.IMS_Backend.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestResponse {
    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String name;
    private String password;
    private String email;
    private String role;
    private List<Member> memberList;
    private Users ourUsers;
}

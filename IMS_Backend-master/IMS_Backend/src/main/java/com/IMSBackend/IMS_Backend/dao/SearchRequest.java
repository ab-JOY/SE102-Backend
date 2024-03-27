package com.IMSBackend.IMS_Backend.dao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchRequest {
    private String firstName;
    private String lastName;
    private String address;
}

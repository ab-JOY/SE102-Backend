package com.IMSBackend.IMS_Backend.exception;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(Long id){
        super("Could not found member with id: " + id);
    }

}
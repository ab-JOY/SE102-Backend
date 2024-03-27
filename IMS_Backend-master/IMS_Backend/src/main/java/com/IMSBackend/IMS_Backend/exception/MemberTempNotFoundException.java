package com.IMSBackend.IMS_Backend.exception;

public class MemberTempNotFoundException extends RuntimeException{
        public MemberTempNotFoundException(Long id_temp){
            super("Could not found member with id: " + id_temp);
        }
}

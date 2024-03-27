package com.IMSBackend.IMS_Backend.controller;

import com.IMSBackend.IMS_Backend.exception.MemberNotFoundException;
import com.IMSBackend.IMS_Backend.exception.MemberTempNotFoundException;
import com.IMSBackend.IMS_Backend.model.MemberTemp;
import com.IMSBackend.IMS_Backend.repository.MemberTempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class MemberTempController {
    @Autowired
    private MemberTempRepository memberTempRepository;

    @PostMapping("/memberTemp")
    MemberTemp newMemberTemp(@RequestBody MemberTemp newMemberTemp){
        return memberTempRepository.save(newMemberTemp);
    }

    @GetMapping("/memberTemp")
    List<MemberTemp> getAllMemberTemp(){
        return memberTempRepository.findAll();
    }

    @GetMapping("/memberTemp/{id_temp}")
    MemberTemp getMemberTempById(@PathVariable Long id_temp){
        return memberTempRepository.findById(id_temp)
                .orElseThrow(()->new MemberTempNotFoundException(id_temp));
    }


    @PutMapping("/memberTemp/{id_temp}")
    MemberTemp updateMemberTemp(@RequestBody MemberTemp newMemberTemp, @PathVariable Long id_temp){
        return memberTempRepository.findById(id_temp)
                .map(memberTemp -> {
                    memberTemp.setFirstName_temp(newMemberTemp.getFirstName_temp());
                    memberTemp.setMiddleName_temp(newMemberTemp.getMiddleName_temp());
                    memberTemp.setLastName_temp(newMemberTemp.getLastName_temp());
                    memberTemp.setAge_temp(newMemberTemp.getAge_temp());
                    memberTemp.setAddress_temp(newMemberTemp.getAddress_temp());
                    memberTemp.setDateOfBirth_temp(newMemberTemp.getDateOfBirth_temp());
                    memberTemp.setSex_temp(newMemberTemp.getSex_temp());
                    memberTemp.setMobileNumber_temp(newMemberTemp.getMobileNumber_temp());
                    memberTemp.setMembershipType_temp(newMemberTemp.getMembershipType_temp());

                    return memberTempRepository.save(memberTemp);
                }).orElseThrow(()->new MemberTempNotFoundException(id_temp));
    }

    @DeleteMapping("/memberTemp/{id_temp}")
    String deleteMemberTemp(@PathVariable Long id_temp){
        if(!memberTempRepository.existsById(id_temp)){
            throw new MemberNotFoundException(id_temp);
        }
        memberTempRepository.deleteById(id_temp);
        return "Member with id: " +id_temp+ " has been deleted successfully";
    }
}

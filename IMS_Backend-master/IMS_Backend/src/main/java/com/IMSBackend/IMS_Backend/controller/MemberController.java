package com.IMSBackend.IMS_Backend.controller;

import com.IMSBackend.IMS_Backend.Service.TransferDataService;
import com.IMSBackend.IMS_Backend.dao.MemberSearch;
import com.IMSBackend.IMS_Backend.dao.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.IMSBackend.IMS_Backend.repository.MemberRepository;
import com.IMSBackend.IMS_Backend.model.Member;
import com.IMSBackend.IMS_Backend.exception.MemberNotFoundException;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberSearch memberSearch;

//    @PostMapping("/member")
//    Member newMember(@RequestBody Member newMember){
//        return memberRepository.save(newMember);
//    }

    @GetMapping("/member")
    List<Member> getAllMember(){
        return memberRepository.findAll();
    }

    @GetMapping("/member/{id}")
    Member getMemberById(@PathVariable Long id){
        return memberRepository.findById(id)
                .orElseThrow(()->new MemberNotFoundException(id));
    }

    @PutMapping("/member/{id}")
    Member updateMember(@RequestBody Member newMember, @PathVariable Long id){
        return memberRepository.findById(id)
                .map(member -> {
                    member.setFirstName(newMember.getFirstName());
                    member.setMiddleName(newMember.getMiddleName());
                    member.setLastName(newMember.getLastName());
                    member.setAge(newMember.getAge());
                    member.setDateOfBirth(newMember.getDateOfBirth());
                    member.setSex(newMember.getSex());
                    member.setAddress(newMember.getAddress());
                    member.setMobileNumber(newMember.getMobileNumber());
                    member.setMembershipType(newMember.getMembershipType());

                    return memberRepository.save(member);
                }).orElseThrow(()->new MemberNotFoundException(id));
    }

    @DeleteMapping("/member/{id}")
    String deleteMember(@PathVariable Long id){
        if(!memberRepository.existsById(id)){
            throw new MemberNotFoundException(id);
        }
        memberRepository.deleteById(id);
        return "Member with id: " +id+ " has been deleted successfully";
    }

    @Autowired
    private TransferDataService transferDataService;

    @PostMapping("/member")
    public ResponseEntity<?> transferMemberTemp(){
        try{
            transferDataService.transferData();
            return ResponseEntity.ok("Success");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error transferring data");
        }
    }

    @GetMapping("/user/alone")
    public ResponseEntity<Object> userAlone(){
        return ResponseEntity.ok("Users alone can access this ApI only");
    }

    @GetMapping("/search")
    public List<Member> searchMembers(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String address
        ){
        return memberSearch.findAllBySimpleQuery(firstName, lastName, address);
    }

    @PostMapping("/search")
    public  List<Member> searchMember(
            @RequestBody SearchRequest searchRequest
    ){
        return memberSearch.findAllByCriteria(searchRequest);
    }
}
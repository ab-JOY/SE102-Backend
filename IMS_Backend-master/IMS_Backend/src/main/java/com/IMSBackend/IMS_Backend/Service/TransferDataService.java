package com.IMSBackend.IMS_Backend.Service;

import com.IMSBackend.IMS_Backend.model.Member;
import com.IMSBackend.IMS_Backend.model.MemberTemp;
import com.IMSBackend.IMS_Backend.repository.MemberRepository;
import com.IMSBackend.IMS_Backend.repository.MemberTempRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferDataService {
    @Autowired
    private MemberTempRepository memberTempRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public void transferData(){
        List<MemberTemp> memberTempData = memberTempRepository.findAll();

        memberTempRepository.deleteAll();

        List<Member> newTableData = memberTempData.stream()
                .map(memberTemp -> {
                    Member member = new Member();
                    member.setFirstName(memberTemp.getFirstName_temp());
                    member.setMiddleName(memberTemp.getMiddleName_temp());
                    member.setLastName(memberTemp.getLastName_temp());
                    member.setAge(memberTemp.getAge_temp());
                    member.setDateOfBirth(memberTemp.getDateOfBirth_temp());
                    member.setSex(memberTemp.getSex_temp());
                    member.setMobileNumber(memberTemp.getMobileNumber_temp());
                    member.setAddress(memberTemp.getAddress_temp());
                    member.setMembershipType(memberTemp.getMembershipType_temp());

                    return member;
                })
                .collect(Collectors.toList());
        memberRepository.saveAll(newTableData);
    }
}

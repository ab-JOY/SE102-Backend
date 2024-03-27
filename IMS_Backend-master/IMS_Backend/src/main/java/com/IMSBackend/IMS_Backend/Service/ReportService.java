package com.IMSBackend.IMS_Backend.Service;

import com.IMSBackend.IMS_Backend.model.Member;
import com.IMSBackend.IMS_Backend.model.Report;
import com.IMSBackend.IMS_Backend.repository.MemberRepository;
import com.IMSBackend.IMS_Backend.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ReportRepository reportRepository;


    public void generateReportForAgeRange(){
        generateReportForAgeRange(18, 24, "18-24");
        generateReportForAgeRange(25, 30, "25-30");
        generateReportForAgeRange(30, Integer.MAX_VALUE, "30-above");
    }

    private void generateReportForAgeRange(int minAge, int maxAge, String ReportName){
        List<Member> members = memberRepository.getMemberByAgeRange(minAge, maxAge);

        List<Report> reports = members.stream()
                .map(member -> {
                    Report report = new Report();
                    report.setFirstName(member.getFirstName());
                    report.setLastName(member.getLastName());
                    report.setAge(member.getAge());

                    return report;
                })
                .collect(Collectors.toList());


        reports.forEach(report -> report.setReportName(report.getReportName()));

        reportRepository.saveAll(reports);
    }

}

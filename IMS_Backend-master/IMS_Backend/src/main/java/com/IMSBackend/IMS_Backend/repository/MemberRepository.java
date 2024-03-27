package com.IMSBackend.IMS_Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.IMSBackend.IMS_Backend.model.Member;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE m.age BETWEEN :minAge AND :maxAge")
    List<Member> getMemberByAgeRange(int minAge, int maxAge);
}

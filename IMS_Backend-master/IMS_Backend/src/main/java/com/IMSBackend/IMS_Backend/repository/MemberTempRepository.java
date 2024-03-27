package com.IMSBackend.IMS_Backend.repository;

import com.IMSBackend.IMS_Backend.model.MemberTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberTempRepository extends JpaRepository<MemberTemp, Long> {
    @Query(value = "select * from member_temp where id_temp =?1", nativeQuery = true)
    Optional<MemberTemp> findById(Long id_temp);
}

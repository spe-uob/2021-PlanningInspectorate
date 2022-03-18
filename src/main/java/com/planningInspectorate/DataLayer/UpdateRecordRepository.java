package com.planningInspectorate.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UpdateRecordRepository extends JpaRepository<UpdateRecord, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE update_record" +
            "SET valid = 1" +
            "WHERE id = ?", nativeQuery = true)
    int updateValid(Long id);


    @Query(value = "SELECT * FROM update_record WHERE id = ?", nativeQuery = true)
    List<String> getRecordInfo(Long id);

    @Modifying
    @Query(value = "DELETE FROM update_record WHERE id = ?", nativeQuery = true)
    int deleteRecord(Long id);


    @Modifying
    @Query(value = "INSERT INTO update_record (person_id, otp, method, name, address_block, email, valid)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?)", nativeQuery = true)
    void addRecord(Long personId, String otp, String method, String name, String addressBlock, String email, int valid);
}
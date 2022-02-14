package com.planningInspectorate.DataLayer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;



@Entity(name = "UpdateRecord")
public class UpdateRecord {

    @Id
    @SequenceGenerator(
            name = "update_sequence",
            sequenceName = "update_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "update_sequence"
    )

    private Long updaterecid;
    private Long personId; // foreign key
    private String otp;
    private Integer updatedbool;

    public UpdateRecord(){}

    public UpdateRecord(Long updaterecid, Long personId, String otp, Integer updatedbool) {
        this.updaterecid = updaterecid;
        this.personId = personId;
        this.otp = otp;
        this.updatedbool = updatedbool;
    }

    public UpdateRecord(Long personId, String otp, Integer updatedbool) {
        this.personId = personId;
        this.otp = otp;
        this.updatedbool = updatedbool;
    }

    public Long getUpdaterecid() {
        return updaterecid;
    }

    public void setUpdaterecid(Long updaterecid) {
        this.updaterecid = updaterecid;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp, Long updaterecid) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String hshpass = updaterecid.toString();
        String hshotp = bCryptPasswordEncoder.encode(hshpass);
        this.otp = hshotp;
    }

    public Integer getUpdatedbool() {
        return updatedbool;
    }

    public void setUpdatedbool(Integer updatedbool) {
        this.updatedbool = updatedbool;
    }

    @Override
    public String toString() {
        return "UpdateRecord{" +
                "updaterecid=" + updaterecid +
                ", personId=" + personId +
                ", otp=" + otp +
                ", updatedbool=" + updatedbool +
                '}';
    }





}

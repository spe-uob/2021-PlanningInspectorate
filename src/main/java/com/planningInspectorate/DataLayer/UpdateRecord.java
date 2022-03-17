package com.planningInspectorate.DataLayer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;



@Entity(name = "update_record")
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

    private Long id;
    private Long personId; // foreign key
    private String otp;
    private String method;
    private String name;
    private String addressBlock; // stored as text rather than varchar
    private String email;

    @Column(columnDefinition = "integer default 0")
    private Integer valid;

    public UpdateRecord(){}

    public UpdateRecord(Long id, Long personId, String otp, String method, String name, String addressBlock, String email, Integer valid) {
        this.id = id;
        this.personId = personId;
        this.otp = otp;
        this.method = method;
        this.name = name;
        this.addressBlock = addressBlock;
        this.email = email;
        this.valid = valid;
    }

    public UpdateRecord(Long personId, String otp, String method, String name, String addressBlock, String email, Integer valid) {
        this.personId = personId;
        this.otp = otp;
        this.method = method;
        this.name = name;
        this.addressBlock = addressBlock;
        this.email = email;
        this.valid = valid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressBlock() {
        return addressBlock;
    }

    public void setAddressBlock(String addressBlock) {
        this.addressBlock = addressBlock;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long updaterecid) {
        this.id = updaterecid;
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

    // once record is loaded the one time pin can be generated, as it is a hash everytime it is generated it will
    // be the same for the record
    public void generateOneTimePinForRecord() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = this.getId().toString();
        this.otp = bCryptPasswordEncoder.encode(hashPass);
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "UpdateRecord{" +
                "id=" + id +
                ", personId=" + personId +
                ", otp='" + otp + '\'' +
                ", method='" + method + '\'' +
                ", name='" + name + '\'' +
                ", addressBlock='" + addressBlock + '\'' +
                ", email='" + email + '\'' +
                ", valid=" + valid +
                '}';
    }
}

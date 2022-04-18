package com.planningInspectorate.ServiceLayer;

import com.planningInspectorate.DataLayer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class oneTimePinUtil {

    @Autowired
    private PersonRepository personRepository;

    // Static function to hash an id into a one time pin
    public String GenerateOneTimePinHashFromId(String id) throws NoSuchAlgorithmException {

        //BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //String otp = bCryptPasswordEncoder.encode(id);
        //personRepository.addOtp(Long.parseLong(id), otp);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashed = digest.digest(id.getBytes(StandardCharsets.UTF_8));

        String otp = "";

        for(byte digit : hashed){
            String hex = Integer.toHexString(0xff & digit);
            if (hex.length() == 1)
                otp = otp + '0';

            otp = otp + hex;
        }

        return otp;
    }
}

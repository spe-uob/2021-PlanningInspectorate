package com.planningInspectorate.ServiceLayer;

import com.planningInspectorate.DataLayer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class oneTimePinUtil {

    @Autowired
    private PersonRepository personRepository;

    // Static function to hash an id into a one time pin
    public String GenerateOneTimePinHashFromId(String id) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String otp = bCryptPasswordEncoder.encode(id);
        //personRepository.addOtp(Long.parseLong(id), otp);

        return otp;
    }
}

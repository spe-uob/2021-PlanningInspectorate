package com.planningInspectorate.ServiceLayer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class oneTimePinUtil {

    // Static function to hash an id into a one time pin
    public static String GenerateOneTimePinHashFromId(String id) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(id);
    }
}

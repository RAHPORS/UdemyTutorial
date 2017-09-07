package com.rahpors.UdemyTutorial.componet;/**
 * Created by ramon on 6/09/17.
 */

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestScript  {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("user"));
    }

}

package com.echaika.oauthtraining.controllers;

import com.echaika.oauthtraining.profiles.UserProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/api/profile")
    public ResponseEntity<UserProfile> profile() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername() + "@test.com";

        UserProfile userProfile = new UserProfile();
        userProfile.setName(user.getUsername());
        userProfile.setEmail(email);

        return ResponseEntity.ok(userProfile);
    }
}

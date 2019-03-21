package com.exadel.mooc.web;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/security")
public class SecurityController {

    @GetMapping(value = "/isAnonymous", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
    }
}

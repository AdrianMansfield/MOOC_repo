package com.exadel.MOOC.web;

import com.exadel.MOOC.dao.repository.staticInfo.IModuleForViewDto;
import com.exadel.MOOC.dto.staticInfo.ModuleForViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private IModuleForViewDto lessonForViewDto;

    @RequestMapping(value = "/isAnonymous", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ModuleForViewDto testMehtod() {
        return lessonForViewDto.findModuleForViewDtoByUserIdAndModuleId(1L, 1L).get();
    }
}

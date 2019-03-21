package com.exadel.mooc.web;

import com.exadel.mooc.dto.UserForEditDTO;
import com.exadel.mooc.dto.UserForViewDTO;
import com.exadel.mooc.security.CustomUser;
import com.exadel.mooc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    private Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        return customUser.getUserId();
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserForViewDTO> findAll() {
        return userService.findAll();
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<UserForEditDTO> userForEditDTOS) {
        userForEditDTOS.forEach(userService::save);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        userService.deleteByID(id);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<UserForEditDTO> userForEditDTOS) {
        userForEditDTOS.forEach(userService::update);
    }

    @GetMapping(value = "/get-user-info", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    UserForViewDTO getUserInfo() {
        return userService.findById(getUserId()).orElseThrow(RuntimeException::new);
    }
}

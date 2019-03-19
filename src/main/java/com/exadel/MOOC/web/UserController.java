package com.exadel.MOOC.web;

import com.exadel.MOOC.dto.UserForEditDTO;
import com.exadel.MOOC.dto.UserForViewDTO;
import com.exadel.MOOC.security.CustomUser;
import com.exadel.MOOC.service.IUserService;
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


    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserForViewDTO> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<UserForEditDTO> userForEditDTOS) {
        userForEditDTOS.forEach(userService::save);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        userService.deleteByID(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<UserForEditDTO> userForEditDTOS) {
        userForEditDTOS.forEach(userService::update);
    }

    @RequestMapping(value = "/get-user-info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    UserForViewDTO getUserInfo() {
        return userService.findById(getUserId()).orElseThrow(RuntimeException::new);
    }
}

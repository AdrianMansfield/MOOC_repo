package com.exadel.MOOC.web;

import com.exadel.MOOC.service.user.UserService;
import com.exadel.MOOC.dto.UserCreateDTO;
import com.exadel.MOOC.dto.UserViewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserViewDTO> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<UserCreateDTO> userCreateDTOS) {
        userCreateDTOS.forEach(userService::save);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        userService.deleteByID(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<UserCreateDTO> userCreateDTOS) {
        userCreateDTOS.forEach(userService::update);
    }
}

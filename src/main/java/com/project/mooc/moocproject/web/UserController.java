package com.project.mooc.moocproject.web;

import com.project.mooc.moocproject.dao.service.user.UserService;
import com.project.mooc.moocproject.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> findAll() {
        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<UserDTO> userDTOS) {
        userDTOS.forEach(userService::save);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        userService.deleteByID(id);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<UserDTO> userDTOS) {
        userDTOS.forEach(userService::update);
    }
}

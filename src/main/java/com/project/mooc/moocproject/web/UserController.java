package com.project.mooc.moocproject.web;

import com.project.mooc.moocproject.dao.service.user.UserService;
import com.project.mooc.moocproject.dto.UserCreateDTO;
import com.project.mooc.moocproject.dto.UserViewDTO;
import com.project.mooc.moocproject.mapper.UserMapper;
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

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserViewDTO> findAll() {
        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody final List<UserCreateDTO> userCreateDTOS) {
        userCreateDTOS.forEach(userService::save);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody final Long id) {
        userService.deleteByID(id);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@RequestBody final List<UserCreateDTO> userCreateDTOS) {
        userCreateDTOS.forEach(userService::update);
    }
}

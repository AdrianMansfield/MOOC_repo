package com.exadel.MOOC.web;

import com.exadel.MOOC.dto.view.UserModuleDTO;
import com.exadel.MOOC.service.IUserModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "user-to-module")
public class UserModuleController {

    @Autowired
    private IUserModuleService userModuleService;


    @RequestMapping(value = "/specific-module", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserModuleDTO> findModuleByUserIdAndModuleId(@RequestParam("moduleId") Long moduleId,
                                                      @RequestParam("userId") Long userId) {
        return userModuleService.findByUserIdAndModuleId(userId, moduleId);
    }

    @RequestMapping(value = "/all-modules", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserModuleDTO> findByUserId(@RequestParam("userId") Long userId) {
        return userModuleService.findByUserId(userId);
    }
}

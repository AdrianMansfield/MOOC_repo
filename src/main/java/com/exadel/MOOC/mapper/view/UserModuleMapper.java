package com.exadel.MOOC.mapper.view;

import com.exadel.MOOC.repository.view.UserModuleViewRepository;
import com.exadel.MOOC.dto.view.UserModuleDTO;
import com.exadel.MOOC.entity.view.UserModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserModuleMapper {

    //TODO add interface call
    @Autowired
    private UserModuleViewRepository userModuleViewRepository;

    public UserModuleDTO toDTO(UserModule userModule) {
        return UserModuleDTO.builder()
                .courseId(userModule.getCourseId())
                .description(userModule.getDescription())
                .id(userModule.getModuleId())
                .order(userModule.getOrder())
                .status(userModule.getStatus())
                .title(userModule.getTitle())
                .titleImg(userModule.getTitleImg())
                .userId(userModule.getUserId())
                .build();
    }
}

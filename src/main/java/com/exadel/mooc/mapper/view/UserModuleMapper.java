package com.exadel.mooc.mapper.view;

import com.exadel.mooc.dto.view.UserModuleDTO;
import com.exadel.mooc.entity.view.UserModule;
import org.springframework.stereotype.Component;

@Component
public class UserModuleMapper {

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

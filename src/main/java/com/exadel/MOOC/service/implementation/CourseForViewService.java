package com.exadel.MOOC.service.implementation;

import com.exadel.MOOC.dao.repository.IUserCourseViewRepository;
import com.exadel.MOOC.dto.CourseDTO;
import com.exadel.MOOC.dto.staticInfo.CourseForViewDto;
import com.exadel.MOOC.entity.itemType.ParentEntityStatus;
import com.exadel.MOOC.entity.view.UserCourse;
import com.exadel.MOOC.service.ICourseForViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseForViewService implements ICourseForViewService {

    @Autowired
    private UserModuleService userModuleService;

    @Autowired
    private IUserCourseViewRepository userCourseViewRepository;

    @Autowired
    private CourseService courseService;

    @Override
    public CourseForViewDto getCourseInfo(Long userId, Long courseId) {
        CourseDTO courseDTO = courseService.findById(courseId);
        List<UserCourse> courseByUserId = userCourseViewRepository.findByUserIdAndCourseId(userId, courseId);
        CourseForViewDto courseForViewDto = CourseForViewDto.builder()
                .id(courseDTO.getId())
                .creator(courseDTO.getCreator())
                .title(courseDTO.getTitle())
                .moduleDTOS(userModuleService.findByUserIdAndCourseId(userId, courseId))
                .build();
        if (courseByUserId.size() > 0) {
            courseForViewDto.setStatus(courseByUserId.get(0).getStatus());
        } else
            courseForViewDto.setStatus(ParentEntityStatus.not_started.name());
        return courseForViewDto;
    }
}

package com.exadel.mooc.service.view.staticInfo;

import com.exadel.mooc.repository.view.IUserCourseViewRepository;
import com.exadel.mooc.dto.CourseDTO;
import com.exadel.mooc.dto.staticInfo.CourseForViewDto;
import com.exadel.mooc.entity.itemType.ParentEntityStatus;
import com.exadel.mooc.entity.view.UserCourse;
import com.exadel.mooc.service.ICourseService;
import com.exadel.mooc.service.view.IUserModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseForViewService implements ICourseForViewService {

    @Autowired
    private IUserModuleService userModuleService;

    @Autowired
    private IUserCourseViewRepository userCourseViewRepository;

    @Autowired
    private ICourseService courseService;

    @Override
    public CourseForViewDto getCourseInfo(Long userId, Long courseId) throws Exception {
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

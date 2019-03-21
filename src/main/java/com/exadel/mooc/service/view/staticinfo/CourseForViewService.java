package com.exadel.mooc.service.view.staticinfo;

import com.exadel.mooc.dto.CourseDTO;
import com.exadel.mooc.dto.staticinfo.CourseForViewDTO;
import com.exadel.mooc.entity.itemtype.ParentEntityStatus;
import com.exadel.mooc.entity.view.UserCourse;
import com.exadel.mooc.exception.EntityNotFoundException;
import com.exadel.mooc.repository.view.IUserCourseViewRepository;
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
    public CourseForViewDTO getCourseInfo(Long userId, Long courseId) {
        CourseDTO courseDTO = courseService.findById(courseId);
        List<UserCourse> courseByUserId = userCourseViewRepository.findByUserIdAndCourseId(userId, courseId);
        CourseForViewDTO courseForViewDto = CourseForViewDTO.builder()
                .id(courseDTO.getId())
                .creator(courseDTO.getCreator())
                .title(courseDTO.getTitle())
                .moduleDTOS(userModuleService.findByUserIdAndCourseId(userId, courseId))
                .build();
        if (!courseByUserId.isEmpty()) {
            courseForViewDto.setStatus(courseByUserId.get(0).getStatus());
        } else
            courseForViewDto.setStatus(ParentEntityStatus.NOT_STARTED.name());
        return courseForViewDto;
    }
}

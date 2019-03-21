package com.exadel.mooc.service.view.staticinfo;

import com.exadel.mooc.dto.staticinfo.CourseForViewDTO;

public interface ICourseForViewService {

    CourseForViewDTO getCourseInfo(Long userId, Long courseId);
}

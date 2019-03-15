package com.exadel.MOOC.service.view.staticInfo;

import com.exadel.MOOC.dto.staticInfo.CourseForViewDto;

public interface ICourseForViewService {

    CourseForViewDto getCourseInfo(Long userId,Long courseId);
}

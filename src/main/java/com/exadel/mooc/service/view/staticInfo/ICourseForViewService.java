package com.exadel.mooc.service.view.staticInfo;

import com.exadel.mooc.dto.staticInfo.CourseForViewDto;

public interface ICourseForViewService {

    CourseForViewDto getCourseInfo(Long userId,Long courseId) throws Exception;
}

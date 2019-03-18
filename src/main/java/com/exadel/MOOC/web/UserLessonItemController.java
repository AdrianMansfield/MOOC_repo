package com.exadel.MOOC.web;

import com.exadel.MOOC.dto.view.UserLessonItemDTO;
import com.exadel.MOOC.security.CustomUser;
import com.exadel.MOOC.service.linkageTable.IUserToCourseHierarchyObjectAggregationService;
import com.exadel.MOOC.service.view.IUserLessonItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user-to-lesson-item")
public class UserLessonItemController {

    @Autowired
    private IUserLessonItemService userLessonItemService;

    @Autowired
    IUserToCourseHierarchyObjectAggregationService userToCourseHierarchyObjectAggregationService;

    private Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        return customUser.getUserId();
    }

    @RequestMapping(value = "/specific-lesson-item", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserLessonItemDTO> findLessonItemByUserIdAndLessonItemId(@RequestParam("lessonItemId") Long lessonItemId,
                                                                  @RequestParam("userId") Long userId) {
        return userLessonItemService.findByUserIdAndLessonItemId(userId, lessonItemId);
    }

    @RequestMapping(value = "/all-lesson-items", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserLessonItemDTO> findByUserId(@RequestParam("userId") Long userId) {
        return userLessonItemService.findByUserId(userId);
    }

    @RequestMapping(value = "/setLessonItemStatus", method = RequestMethod.POST)
    void setLessonItemStatus(@RequestBody Long lessonItemId) {
        userToCourseHierarchyObjectAggregationService.setStatusForLessonItem(lessonItemId, getUserId());
    }
}

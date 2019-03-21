package com.exadel.mooc.web;

import com.exadel.mooc.dto.view.UserLessonItemDTO;
import com.exadel.mooc.security.CustomUser;
import com.exadel.mooc.service.linkagetable.IUserToCourseHierarchyObjectAggregationService;
import com.exadel.mooc.service.view.IUserLessonItemService;
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
    IUserToCourseHierarchyObjectAggregationService userToCourseHierarchyObjectAggregationService;
    @Autowired
    private IUserLessonItemService userLessonItemService;

    private Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        return customUser.getUserId();
    }

    @GetMapping(value = "/specific-lesson-item", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserLessonItemDTO> findLessonItemByUserIdAndLessonItemId(@RequestParam("lessonItemId") Long lessonItemId,
                                                                  @RequestParam("userId") Long userId) {
        return userLessonItemService.findByUserIdAndLessonItemId(userId, lessonItemId);
    }

    @GetMapping(value = "/all-lesson-items", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserLessonItemDTO> findByUserId(@RequestParam("userId") Long userId) {
        return userLessonItemService.findByUserId(userId);
    }

    @PostMapping(value = "/setLessonItemStatus")
    void setLessonItemStatus(@RequestBody Long lessonItemId) {
        userToCourseHierarchyObjectAggregationService.setStatusForLessonItem(lessonItemId, getUserId());
    }
}

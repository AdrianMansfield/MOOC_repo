package com.exadel.mooc.service.linkageTable;

import com.exadel.mooc.repository.linkageTable.IUserToModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserToModuleService implements IUserToModuleService {

    @Autowired
    private IUserToModuleRepository userToModuleRepository;

    @Override
    public int countOfNotFinishedModules(Long lessonItemId, Long userId) {
        return userToModuleRepository.countOfNotFinishedModules(lessonItemId, userId);
    }

    @Override
    public int countOfStartedModules(Long lessonItemId, Long userId) {
        return userToModuleRepository.countOfStartedModules(lessonItemId, userId);
    }

    @Transactional
    @Override
    public void updateStatusByUserIdAndLessonItemId(Long lessonItemId, Long userId) {
        userToModuleRepository.updateStatusByUserIdAndLessonItemId(lessonItemId, userId);
    }

    @Transactional
    @Override
    public void setStatusInProgressByUserIdAndLessonItemId(Long lessonItemId, Long userId) {
        userToModuleRepository.setStatusInProgressByUserIdAndLessonItemId(lessonItemId, userId);
    }
}

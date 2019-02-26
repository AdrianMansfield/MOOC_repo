package com.project.mooc.moocproject.dao.service.user;

import com.project.mooc.moocproject.dto.UserCreateDTO;
import com.project.mooc.moocproject.dto.UserViewDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(UserCreateDTO userCreateDTO);

    void deleteByID(Long id);

    void update(UserCreateDTO userCreateDTO);

    List<UserViewDTO> findAll();

    Optional<UserViewDTO> findByUserName(String userName);

}

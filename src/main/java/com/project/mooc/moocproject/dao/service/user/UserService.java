package com.project.mooc.moocproject.dao.service.user;

import com.project.mooc.moocproject.dto.ModuleDTO;
import com.project.mooc.moocproject.dto.UserDTO;

import java.util.List;

public interface UserService {

    void save(UserDTO userDTO);

    void deleteByID(Long id);

    void update(UserDTO userDTO);

    List<UserDTO> findAll();
}

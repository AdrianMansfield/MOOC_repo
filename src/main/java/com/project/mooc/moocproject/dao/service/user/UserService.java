package com.project.mooc.moocproject.dao.service.user;

import com.project.mooc.moocproject.dto.UserDTO;
import com.project.mooc.moocproject.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(UserDTO userDTO);

    void deleteByID(Long id);

    void update(UserDTO userDTO);

    List<UserDTO> findAll();

    Optional<UserDTO> findByUserName(String userName);

}

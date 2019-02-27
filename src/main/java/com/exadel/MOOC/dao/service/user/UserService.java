package com.exadel.MOOC.dao.service.user;

import com.exadel.MOOC.dto.UserCreateDTO;
import com.exadel.MOOC.dto.UserViewDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(UserCreateDTO userCreateDTO);

    void deleteByID(Long id);

    void update(UserCreateDTO userCreateDTO);

    List<UserViewDTO> findAll();

    Optional<UserViewDTO> findByUserName(String userName);
}

package com.exadel.MOOC.service;

import com.exadel.MOOC.dto.UserForEditDTO;
import com.exadel.MOOC.dto.UserForViewDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    void save(UserForEditDTO userForEditDTO);

    void deleteByID(Long id);

    void update(UserForEditDTO userForEditDTO);

    List<UserForViewDTO> findAll();

    Optional<UserForViewDTO> findByUserName(String userName);
}

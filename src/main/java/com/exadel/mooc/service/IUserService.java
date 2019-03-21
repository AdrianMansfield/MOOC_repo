package com.exadel.mooc.service;

import com.exadel.mooc.dto.UserForEditDTO;
import com.exadel.mooc.dto.UserForViewDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    void save(UserForEditDTO userForEditDTO);

    void deleteByID(Long id);

    void update(UserForEditDTO userForEditDTO);

    List<UserForViewDTO> findAll();

    Optional<UserForViewDTO> findByUserName(String userName);

    Optional<UserForViewDTO> findById(Long id);
}

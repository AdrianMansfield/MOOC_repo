package com.exadel.mooc.service;

import com.exadel.mooc.dto.UserForEditDTO;
import com.exadel.mooc.dto.UserForViewDTO;
import com.exadel.mooc.entity.User;
import com.exadel.mooc.mapper.UserMapper;
import com.exadel.mooc.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(UserForEditDTO userForEditDTO) {
        userRepository.save(userMapper.toEntity(userForEditDTO));
    }

    @Override
    public void deleteByID(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(UserForEditDTO userForEditDTO) {
        userRepository.save(userMapper.toEntity(userForEditDTO));
    }

    @Override
    public List<UserForViewDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UserForViewDTO> findByUserName(String userName) {
        Optional<User> userOptional = userRepository.findByUserName(userName);
        if (userOptional.isPresent()) {
            return Optional.of(userMapper.toDTO(userOptional.get()));
        } else throw new RuntimeException("not found user with name " + userName);
    }

    @Override
    public Optional<UserForViewDTO> findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return Optional.of(userMapper.toDTO(userOptional.get()));
        } else throw new RuntimeException("not found user with id " + id);
    }


}

package com.project.mooc.moocproject.dao.service.user.implementation;

import com.project.mooc.moocproject.dao.repository.UserRepository;
import com.project.mooc.moocproject.dao.service.user.UserService;
import com.project.mooc.moocproject.dto.UserDTO;
import com.project.mooc.moocproject.entity.User;
import com.project.mooc.moocproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(UserDTO userDTO) {
        userRepository.save(userMapper.toEntity(userDTO));
    }

    @Override
    public void deleteByID(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(UserDTO userDTO) {
        userRepository.save(userMapper.toEntity(userDTO));
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findByUserName(String userName) {
        return Optional.of(userMapper.toDTO(userRepository.findByUserName(userName)));
    }
}

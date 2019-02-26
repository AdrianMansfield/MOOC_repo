package com.project.mooc.moocproject.dao.service.user.implementation;

import com.project.mooc.moocproject.dao.repository.UserRepository;
import com.project.mooc.moocproject.dao.service.user.UserService;
import com.project.mooc.moocproject.dto.UserCreateDTO;
import com.project.mooc.moocproject.dto.UserViewDTO;
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
    public void save(UserCreateDTO userCreateDTO) {
        userRepository.save(userMapper.toEntity(userCreateDTO));
    }

    @Override
    public void deleteByID(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(UserCreateDTO userCreateDTO) {
        userRepository.save(userMapper.toEntity(userCreateDTO));
    }

    @Override
    public List<UserViewDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UserViewDTO> findByUserName(String userName) {
        Optional<User> userOptional = userRepository.findByUserName(userName);
        if (userOptional.isPresent()) {
            return Optional.of(userMapper.toDTO(userOptional.get()));
        } else throw new RuntimeException("not found user with name " + userName);
    }
}

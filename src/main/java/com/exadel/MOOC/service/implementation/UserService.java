package com.exadel.MOOC.service.implementation;

import com.exadel.MOOC.dao.repository.UserRepository;
import com.exadel.MOOC.service.IUserService;
import com.exadel.MOOC.dto.UserCreateDTO;
import com.exadel.MOOC.dto.UserViewDTO;
import com.exadel.MOOC.entity.User;
import com.exadel.MOOC.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

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

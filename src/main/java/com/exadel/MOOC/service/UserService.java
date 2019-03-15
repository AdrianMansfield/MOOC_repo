package com.exadel.MOOC.service;

import com.exadel.MOOC.repository.IUserRepository;
import com.exadel.MOOC.dto.UserForEditDTO;
import com.exadel.MOOC.dto.UserForViewDTO;
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
}

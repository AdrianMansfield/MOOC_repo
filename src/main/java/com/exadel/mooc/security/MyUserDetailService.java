package com.exadel.mooc.security;

import com.exadel.mooc.entity.User;
import com.exadel.mooc.exception.UserNotFoundException;
import com.exadel.mooc.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UserNotFoundException("can not find user by userName:" + username));
        return new CustomUser(user.getUserName(), user.getPassword(), new ArrayList<>(), user.getId());
    }
}

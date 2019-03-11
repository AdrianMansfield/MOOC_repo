package com.exadel.MOOC.security;

import com.exadel.MOOC.dao.repository.IUserRepository;
import com.exadel.MOOC.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("MyUserDetailService error"));
        return new CustomUser(user.getUserName(), user.getPassword(), new ArrayList<>(), user.getId());
    }
}

package com.example.demo.service;

import com.example.demo.repository.AuthenticationRepository;
import com.example.demo.repository.entity.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EmployeeDatailService implements UserDetailsService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Authentication> authentication = authenticationRepository.findById(username);

        if (!authentication.isPresent()) {
            throw new UsernameNotFoundException(
                    "No employee present with employee no : " + username
            );
        }

        return new EmployeeDetail(authentication.get().getEmployee());

    }
}

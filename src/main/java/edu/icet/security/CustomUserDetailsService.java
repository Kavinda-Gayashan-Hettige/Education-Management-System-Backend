package edu.icet.security;

import edu.icet.model.entity.User;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        
       
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                user.isActive(), 
                true,
                true, 
                true, 
                Collections.singletonList(new SimpleGrantedAuthority( user.getRole().name()))
        );
    }
}
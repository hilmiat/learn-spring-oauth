package com.example.oauthdemo.sevices;

import com.example.oauthdemo.entities.User;
import com.example.oauthdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

//    @PostConstruct
//    public void tambahuser(){
//        User user1 = new User();
//        user1.setUsername("hendra");
//        user1.setPassword(encoder.encode("pass1"));
//        user1.setIsactive(true);
//        userRepository.save(user1);
//
//        User user2 = new User();
//        user2.setUsername("user2");
//        user2.setPassword(encoder.encode("pass2"));
//        user2.setIsactive(true);
//        userRepository.save(user2);
//    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("invalid");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority("Role Admin"))
        );
    }

}

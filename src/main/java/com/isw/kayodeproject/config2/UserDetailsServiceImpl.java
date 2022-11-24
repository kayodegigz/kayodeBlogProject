//package com.isw.kayodeproject.config2;
//
//
//import com.isw.kayodeproject.entity.User;
//import com.isw.kayodeproject.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//    @Service
//    public class UserDetailsServiceImpl implements UserDetailsService {
//
//        @Autowired
//        private UserRepository userRepo;
//
//        @Override
//        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//            User user = userRepo.findByEmail(email);
//
//            if (user != null) {
//                return new CustomUserDetails(user);
//            }
//
//            throw new UsernameNotFoundException("user not available");
//        }
//
//}

package com.eazybytes.eazyschool.config.security;

import com.eazybytes.eazyschool.entity.RoleEntity;
import com.eazybytes.eazyschool.entity.UserEntity;
import com.eazybytes.eazyschool.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("username is empty");
        }
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("user not found");
        }
        // Tạo ra danh sách quyền của spring security
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        // Lấy ra danh sách quyền của user
        Set<RoleEntity> roleEntities = userEntity.getRoleEntities();
        for (RoleEntity roleEntity : roleEntities) {
            // thềm từng phần tử quyền cho security
            grantedAuthorities.add(new SimpleGrantedAuthority(roleEntity.getName()));
        }

        // trả về đối tượng user với các thông tin username, passowrd, roles để spring security thực hiện
        // xác thực với username, password được truyền lên từ FE
        return new org.springframework.security.core.userdetails.User(userEntity.getUsername(), userEntity.getPassword(), grantedAuthorities);
    }
}

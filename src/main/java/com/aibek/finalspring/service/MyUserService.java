package com.aibek.finalspring.service;

import com.aibek.finalspring.entity.Permission;
import com.aibek.finalspring.entity.UserModel;
import com.aibek.finalspring.repository.PermissionRepo;
import com.aibek.finalspring.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyUserService implements UserDetailsService {

    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PermissionRepo permissionRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByEmail(username);

        if (Objects.nonNull(user)) {
            return user;
        }

        throw new UsernameNotFoundException("User Not Found");
    }

    public void registr(UserModel model) {
        UserModel check = userRepository.findByEmail(model.getEmail());
        if (check == null) {
            model.setPassword(passwordEncoder.encode(model.getPassword()));
            Permission userPermission = permissionRepo.findByName("ROLE_USER");

            if (userPermission != null) {
                List<Permission> permissions = List.of(userPermission);
                model.setPermissions(permissions);
                userRepository.save(model);
            }
        }
    }
}

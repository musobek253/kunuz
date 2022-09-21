package com.example.kunuzbek.companent;

import com.example.kunuzbek.entity.Role;
import com.example.kunuzbek.entity.User;
import com.example.kunuzbek.entity.enam.Huquq;
import com.example.kunuzbek.pyload.Appconstantis;
import com.example.kunuzbek.repo.RoleRepository;
import com.example.kunuzbek.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.example.kunuzbek.entity.enam.Huquq.*;
@Component
public class Dataloader implements CommandLineRunner {
    @Autowired(required = false)
    private  UserRepository userRepository;
    @Autowired(required = false)
    private  RoleRepository roleRepository;
    @Autowired(required = false)
    private PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    private String initialModeType;

    @Override
    public void run(String... args) throws Exception {
        if (initialModeType.equals("always")){
            Huquq[] huquqs = Huquq.values();
            Role Admin = roleRepository.save(new Role(
                    Appconstantis.ADMIN,
                    Arrays.asList(huquqs)
            ));

            Role user = roleRepository.save(new Role(
                    Appconstantis.USER,
                    Arrays.asList(ADD_COMMENT, DELETE_MY_COMMENT, EDIT_COMMENT)
            ));

            User admin= userRepository.save(new User(
                    "Admin",
                    "Admin",
                    passwordEncoder.encode("12345"),
                    true,
                    Admin
            ));

            User userapp = userRepository.save(new User(
                    "user",
                    "user",
                    passwordEncoder.encode("12345"),
                    true,
                    user
            ));

        }

    }
}

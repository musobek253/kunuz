package com.example.kunuzbek.companent;

import com.example.kunuzbek.entity.Role;
import com.example.kunuzbek.entity.User;
import com.example.kunuzbek.entity.enam.Huquq;
import com.example.kunuzbek.pyload.Appconstantis;
import com.example.kunuzbek.repo.RoleRepository;
import com.example.kunuzbek.repo.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

import static com.example.kunuzbek.entity.enam.Huquq.*;

public class Dataloader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Value("${spring.sql.init.mode}")
    private String initialModeType;

    public Dataloader(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


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

            User AdminSystem = userRepository.save(new User(
                    "Admin",
                    "Admin",
                    "12345",
                    Admin,
                    true
            ));

            User userapp = userRepository.save(new User(
                    "user",
                    "user",
                    "12345",
                    user,
                    true
            ));

        }

    }
}

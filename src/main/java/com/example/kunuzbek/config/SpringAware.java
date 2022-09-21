package com.example.kunuzbek.config;

import com.example.kunuzbek.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public class SpringAware implements AuditorAware<UUID> {
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Optional<UUID> getCurrentAuditor() {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

           if (authentication != null
                   && authentication.isAuthenticated()
                   && !authentication.getPrincipal().equals("anonymousUser")) {
           User user = (User) authentication.getPrincipal();
            return Optional.of(user.getId());
        } return Optional.empty();


    }
}

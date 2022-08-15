package com.example.kunuzbek.entity;

import com.example.kunuzbek.entity.enam.Huquq;
import com.example.kunuzbek.entity.temp.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User extends AbsEntity implements UserDetails {
    @Column(nullable = false)
    private String fullName;

    @Column(unique = true,nullable = false)
    private String username;

    private String password;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = false;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Huquq> huquqList = this.role.getHuquqList();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Huquq huquq : huquqList) {
            grantedAuthorities.add(new SimpleGrantedAuthority(huquq.name()));
        }
        return grantedAuthorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public User(String fullName, String username, String password, Role role) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String fullName, String username, String password, boolean enabled, Role role) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }
}

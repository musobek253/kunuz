package com.example.kunuzbek.entity;

import com.example.kunuzbek.entity.enam.Huquq;
import com.example.kunuzbek.entity.temp.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
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

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Role role;

    private boolean enabled;

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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}

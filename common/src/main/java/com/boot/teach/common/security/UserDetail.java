package com.boot.teach.common.security;

import com.boot.teach.model.auth.TeachUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * userDetail
 */
@Data
@NoArgsConstructor
public class UserDetail implements UserDetails {
    //用户信息
    TeachUser userModel;
    //用户权限
    List<String> permission;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        //权限授权
        permission.forEach(k->{
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(k);
            authorities.add(simpleGrantedAuthority);
        });
        return authorities;
    }
    public UserDetail(TeachUser user, List<String> permission){
        this.userModel = user;
        this.permission = permission;
    }

    @Override
    public String getPassword() {
        return userModel.getUserPassword();
    }

    @Override
    public String getUsername() {
        return userModel.getUserAccount();
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

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.boot.teach.service.auth.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.teach.dao.mapper.auth.RoleMapper;
import com.boot.teach.model.auth.TeachUserRole;
import com.boot.teach.service.auth.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;

/**
 * 角色服务实现类
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, TeachUserRole> implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<String> selectRoleByUserId(String userId) {
        if (StringUtils.isEmpty(userId)){
            throw new IllegalArgumentException("用户不能为空");
        }
        return roleMapper.selectRoleByUserId(userId);
    }
}

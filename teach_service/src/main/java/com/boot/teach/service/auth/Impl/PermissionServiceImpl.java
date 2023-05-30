package com.boot.teach.service.auth.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.teach.common.constance.ExceptionMessageConstance;
import com.boot.teach.dao.auth.RolePermissionMapper;
import com.boot.teach.model.auth.Permission;
import com.boot.teach.service.auth.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.naming.NoPermissionException;
import java.util.List;
import java.util.Objects;

/**
 * 用户权限实现类
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<RolePermissionMapper, Permission> implements PermissionService {
    @Autowired
    RolePermissionMapper permissionMapper;
    @Override
    public List<String> getPermissionByUserId(String userId) throws NoPermissionException {
        List<String> permission = permissionMapper.getPermissionByUserId(userId);
        if (Objects.isNull(permission)){
            throw new NoPermissionException(ExceptionMessageConstance.USER_NO_PERMISSION);
        }
        return permission;
    }
}

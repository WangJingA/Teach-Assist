package com.boot.teach.dao.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.teach.model.auth.Permission;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionMapper extends BaseMapper<Permission> {
     List<String> getUserRoleByUserId(@Param("userId") String userId);

     List<String> getPermissionByRoleId(@Param("roleId") int roleId);

     List<String> getPermissionByUserId(@Param("userId")String userId);
}

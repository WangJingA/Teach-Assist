package com.boot.teach.dao.mapper.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.teach.model.auth.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    public List<String> getUserRoleByUserId(@Param("userId") String userId);

    public List<String> getPermissionByRoleId(@Param("roleId") int roleId);
}

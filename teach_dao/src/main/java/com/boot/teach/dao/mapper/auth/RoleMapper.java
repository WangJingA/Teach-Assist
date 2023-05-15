package com.boot.teach.dao.mapper.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.teach.model.auth.TeachUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<TeachUserRole> {
    /**
     * 依靠用户id查询用户拥有的角色
     * @param userId
     * @return
     */
    public List<String> selectRoleByUserId(@Param("userId") String userId);
}

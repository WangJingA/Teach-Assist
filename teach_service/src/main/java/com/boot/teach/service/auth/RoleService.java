package com.boot.teach.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.teach.model.auth.TeachUserRole;

import java.util.List;

public interface RoleService extends IService<TeachUserRole>  {
     List<String> selectRoleByUserId(String userId);
}

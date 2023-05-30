package com.boot.teach.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.teach.model.auth.Permission;
import org.apache.ibatis.annotations.Param;

import javax.naming.NoPermissionException;
import java.util.List;

public interface PermissionService extends IService<Permission> {

    List<String> getPermissionByUserId(@Param("userId")String userId) throws NoPermissionException;
}

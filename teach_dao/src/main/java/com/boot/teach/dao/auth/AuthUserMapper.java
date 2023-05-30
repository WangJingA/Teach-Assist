package com.boot.teach.dao.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.teach.model.auth.TeachUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthUserMapper extends BaseMapper<TeachUser> {

}

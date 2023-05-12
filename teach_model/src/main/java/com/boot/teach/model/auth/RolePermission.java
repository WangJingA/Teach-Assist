package com.boot.teach.model.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("角色权限")
public class RolePermission {
    @ApiModelProperty("uuid")
    String id;

    @ApiModelProperty("角色uid")
    int roleId;

    @ApiModelProperty("权限uid")
    int permissionId;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

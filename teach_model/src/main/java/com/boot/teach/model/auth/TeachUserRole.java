package com.boot.teach.model.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("用户角色")
public class TeachUserRole {
    @ApiModelProperty("id")
    int id;

    @ApiModelProperty("用户id")
    String userId;

    @ApiModelProperty("用户角色")
    String userRole;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

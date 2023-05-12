package com.boot.teach.model.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("角色")
public class TeachRole {
    @ApiModelProperty("id")
    int id;

    @ApiModelProperty("用户角色编码")
    String roleCode;

    @ApiModelProperty("用户角色描述")
    String roleDesc;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

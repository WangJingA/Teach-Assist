package com.boot.teach.model.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("权限")
public class Permission {
    @ApiModelProperty("id")
    int id;

    @ApiModelProperty("父组件id")
    int parentId;

    @ApiModelProperty("组件名")
    String componentName;

    @ApiModelProperty("组件")
    String component;

    @ApiModelProperty("展示名")
    String displayName;

    @ApiModelProperty("路径")
    String path;

    @ApiModelProperty("权限编码")
    String permissionCode;

    @ApiModelProperty("图标")
    String icon;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

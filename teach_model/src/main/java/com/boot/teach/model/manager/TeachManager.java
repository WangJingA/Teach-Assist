package com.boot.teach.model.manager;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("管理员")
public class TeachManager {
    @ApiModelProperty("uuid")
    String uuid;

    @ApiModelProperty("管理员姓名")
    String teachManager;

    @ApiModelProperty("管理员手机号码")
    String teachManagerPhone;

    @ApiModelProperty("管理员邮箱")
    String teachManagerMail;

    @ApiModelProperty("头像")
    String teachManagerIcon;

    @ApiModelProperty("密码")
    String teachManagerPassword;

    @ApiModelProperty("账号")
    String teachManagerAccount;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

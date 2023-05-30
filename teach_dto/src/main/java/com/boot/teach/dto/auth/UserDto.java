package com.boot.teach.dto.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "用户信息")
public class UserDto {
    @ApiModelProperty(value = "uuid")
    String uuid;

    @ApiModelProperty(value = "用户账号（一般是学号或者工号）")
    String userAccount;

    @ApiModelProperty(value = "密码")
    String userPassword;

    @ApiModelProperty(value = "邮箱")
    String userMail;

    @ApiModelProperty(value = "手机号")
    String userPhone;

    @ApiModelProperty(value = "状态")
    int userState;

    @ApiModelProperty(value = "创建时间")
    Date createTime;

    @ApiModelProperty(value = "更新时间")
    Date updateTime;
}

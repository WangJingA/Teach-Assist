package com.boot.teach.vo.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 前端用户登录的接受类
 */

@Data
@ApiModel(value = "用户信息")
public class UserVo {
    @ApiModelProperty(value = "uuid")
    String uuid;

    @ApiModelProperty(value = "用户账号")
    String userAccount;

    @ApiModelProperty(value = "用户密码")
    String userPassword;

    @ApiModelProperty(value = "用户邮箱")
    String userMail;

    @ApiModelProperty(value = "用户手机号")
    String userPhone;
}

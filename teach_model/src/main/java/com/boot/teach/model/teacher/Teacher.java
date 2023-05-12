package com.boot.teach.model.teacher;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "教师信息表")
public class Teacher {
    @ApiModelProperty(value = "uuid")
    String uuid;

    @ApiModelProperty(value = "教师名")
    String teacherName;

    @ApiModelProperty(value = "教师邮箱")
    String teacherMail;

    @ApiModelProperty(value = "教师手机号码")
    String teacherPhone;

    @ApiModelProperty(value = "教师所在学校")
    String teacherCollege;

    @ApiModelProperty(value = "教师所在学院")
    String teacherDepartment;

    @ApiModelProperty(value = "教师账号")
    String teacherAccount;

    @ApiModelProperty(value = "教师密码")
    String teacherPassword;

    @ApiModelProperty(value = "头像")
    String teacherIcon;

    @ApiModelProperty(value = "教师工号")
    String teacherWorkNumber;

    @ApiModelProperty(value = "教师头衔")
    String teacherTitle;

    @ApiModelProperty(value = "教师描述")
    String teacherDes;

    @ApiModelProperty(value = "创建时间")
    Date createTime;

    @ApiModelProperty(value = "更新时间")
    Date updateTime;
}

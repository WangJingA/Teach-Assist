package com.boot.teach.model.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "学生班级表")
public class StudentClass {
    @ApiModelProperty(value = "uuid")
    String uuid;

    @ApiModelProperty(value = "学生姓名")
    String sudentName;

    @ApiModelProperty(value = "学号")
    String sudentSchoolNumber;

    @ApiModelProperty(value = "学生班级")
    String sudentClass;

    @ApiModelProperty(value = "专业")
    String sudentMajor;

    @ApiModelProperty(value = "手机号")
    String sudentPhone;

    @ApiModelProperty(value = "邮箱")
    String sudentMail;

    @ApiModelProperty(value = "学校")
    String sudentCollege;

    @ApiModelProperty(value = "学院")
    String sudentDepartment;

    @ApiModelProperty(value = "头像")
    String sudentIcon;

    @ApiModelProperty(value = "账号")
    String sudentAccount;

    @ApiModelProperty(value = "密码，采用加密")
    String sudentPassword;

    @ApiModelProperty(value = "性别")
    String sudentSex;

    @ApiModelProperty(value = "班级名")
    String className;

    @ApiModelProperty(value = "班级所属院系")
    String classDepartment;

    @ApiModelProperty(value = "班级所属学校")
    String classCollege;

    @ApiModelProperty(value = "班级创建状态")
    int classState;

    @ApiModelProperty(value = "创建时间")
    Date createTime;

    @ApiModelProperty(value = "修改时间")
    Date updateTime;
}

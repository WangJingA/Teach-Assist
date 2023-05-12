package com.boot.teach.model.teacher;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("教师授课班级")
public class TeacherClass {
    @ApiModelProperty("uuid")
    String uuid;

    @ApiModelProperty("班级uid")
    String classUid;

    @ApiModelProperty("教师uid")
    String teacherUid;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

package com.boot.teach.model.course;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("课程简介")
public class CourseGeneration {
    @ApiModelProperty("uid")
    String uuid;

    @ApiModelProperty("课程uid")
    String uid;

    @ApiModelProperty("课程教师uid")
    String teacherUid;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

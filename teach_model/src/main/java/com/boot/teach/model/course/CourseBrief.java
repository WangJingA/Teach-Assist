package com.boot.teach.model.course;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("课程简介")
public class CourseBrief {
    @ApiModelProperty(value = "uid")
    String uuid;

    @ApiModelProperty(value = "课程简介")
    String courseBrief;

    @ApiModelProperty(value = "课程uid")
    String courseUid;

    @ApiModelProperty(value = "课程教师uid")
    String courseTeacherUid;

    @ApiModelProperty(value = "创建时间")
    Date createTime;

    @ApiModelProperty(value = "更新时间")
    Date updateTime;
}

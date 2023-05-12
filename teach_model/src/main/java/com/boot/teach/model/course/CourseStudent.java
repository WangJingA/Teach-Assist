package com.boot.teach.model.course;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("课程学生表")
public class CourseStudent {
    @ApiModelProperty("uuid")
    String uuid;

    @ApiModelProperty("课程uid")
    String courseUid;

    @ApiModelProperty("学生uid")
    String sudentUid;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

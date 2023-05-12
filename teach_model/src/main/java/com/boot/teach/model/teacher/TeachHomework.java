package com.boot.teach.model.teacher;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("作业")
public class TeachHomework {
    @ApiModelProperty("uuid")
    String uuid;

    @ApiModelProperty("教师uid")
    String teacherUid;

    @ApiModelProperty("课程uid")
    String courseUid;

    @ApiModelProperty("作业描述")
    String homeworkDesc;

    @ApiModelProperty("作业内容")
    String homeworkContent;

    @ApiModelProperty("作业开始时间")
    Date homeworkBeginTime;

    @ApiModelProperty("作业结束时间")
    Date homeworkEndTime;

    @ApiModelProperty("作业状态，0：未到开始时间，1：进行中，2：已过时")
    int homeworkState;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

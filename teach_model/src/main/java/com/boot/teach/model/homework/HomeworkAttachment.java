package com.boot.teach.model.homework;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("作业附件")
public class HomeworkAttachment {
    @ApiModelProperty("uuid")
    String uuid;

    @ApiModelProperty("附件")
    String homeworkAttachment;

    @ApiModelProperty("课程uid")
    String courseUid;

    @ApiModelProperty("教师uid")
    String teacherUid;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

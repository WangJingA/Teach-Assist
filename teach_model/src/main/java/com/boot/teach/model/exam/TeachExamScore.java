package com.boot.teach.model.exam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("学生考试成绩")
public class TeachExamScore {
    @ApiModelProperty("uid")
    String uuid;

    @ApiModelProperty("试卷uid")
    String examUid;

    @ApiModelProperty("课程uid")
    String courseUid;

    @ApiModelProperty("学生uid")
    String sudentUid;

    @ApiModelProperty("学生成绩")
    double sudentScore;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

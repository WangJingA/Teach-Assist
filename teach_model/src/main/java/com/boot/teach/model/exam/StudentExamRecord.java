package com.boot.teach.model.exam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("学生考试记录")
public class StudentExamRecord {
    @ApiModelProperty("uuid")
    String uuid;

    @ApiModelProperty("考试uid")
    String examUid;

    @ApiModelProperty("学生uid")
    String sudentUid;

    @ApiModelProperty("学生考试成绩")
    String sudentExamScore;

    @ApiModelProperty("学生考试结果等级")
    String sudentExamResult;

    @ApiModelProperty("学生考试结果等级uid")
    String sudentExamResultUid;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;

}

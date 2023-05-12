package com.boot.teach.model.exam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("试卷题目分数")
public class ExamQuestionScore {
    @ApiModelProperty("uid")
    String uuid;

    @ApiModelProperty("试卷id")
    String examUid;

    @ApiModelProperty("题目类型，列如英语，数学")
    String questionCategoryId;

    @ApiModelProperty("题目分数")
    double questionScore;

    @ApiModelProperty("题目类型")
    int questionTypeId;

    @ApiModelProperty("题目来源")
    int questionSource;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

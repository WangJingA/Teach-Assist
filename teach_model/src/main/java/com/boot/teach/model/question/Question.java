package com.boot.teach.model.question;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("试卷问题")
public class Question {
    @ApiModelProperty("id")
    String questionId;

    @ApiModelProperty("问题")
    String questionName;

    @ApiModelProperty("问题分数")
    String questionScore;

    @ApiModelProperty("问题的创建者")
    String questinCreatorId;

    @ApiModelProperty("试卷uid")
    String examUid;

    @ApiModelProperty("问题等级")
    int questionLevelId;

    @ApiModelProperty("题目的类型，比如单选、多选、判断等")
    int questionTypeId;

    @ApiModelProperty("题目的类型，比如数学、英语、政治等")
    int questionCategoryId;

    @ApiModelProperty("题目描述")
    String questionDescription;

    @ApiModelProperty("题目选项ids")
    String questionOptionIds;

    @ApiModelProperty("题目答案ids")
    String questionAnswerOptionIds;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

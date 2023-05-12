package com.boot.teach.model.question;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("题目选项")
public class QuestionOption {
    @ApiModelProperty("题目选项id")
    int questionOptionId;

    @ApiModelProperty("题目选项")
    String questionOptionContent;

    @ApiModelProperty("题目选项描述，可以用于题目答案解析")
    String questionOptionDescription;
}

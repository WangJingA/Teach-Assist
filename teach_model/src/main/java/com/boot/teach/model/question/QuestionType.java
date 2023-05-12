package com.boot.teach.model.question;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("题目类型")
public class QuestionType {
    @ApiModelProperty("题目类型id")
    int questionTypeId;

    @ApiModelProperty("题目类型名称")
    String questionTypeName;

    @ApiModelProperty("题目描述")
    String questionTypeDescription;
}

package com.boot.teach.model.exam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("考试结果等级")
public class ExamRecordLevel {
    @ApiModelProperty("id")
    int examRecordLevelId;

    @ApiModelProperty("考试等级名称")
    String examrecordLevelName;

    @ApiModelProperty("考试结果等级描述：优秀，中等，及格，不及格")
    String examRecordLevelDescription;
}

package com.boot.teach.model.exam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("考试难度等级")
public class ExamLevel {
    @ApiModelProperty("uid")
    String uuid;

    @ApiModelProperty("等级名")
    String examLevelName;

    @ApiModelProperty("等级描述")
    String examLevelDesc;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

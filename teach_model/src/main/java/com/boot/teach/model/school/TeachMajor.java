package com.boot.teach.model.school;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("专业")
public class TeachMajor {
    @ApiModelProperty("uuid")
    String uuid;

    @ApiModelProperty("专业名")
    String majorName;

    @ApiModelProperty("学院uid")
    String departmentUid;

    @ApiModelProperty("专业图标")
    String majorIcon;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

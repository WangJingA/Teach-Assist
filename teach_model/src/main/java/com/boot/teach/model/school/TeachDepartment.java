package com.boot.teach.model.school;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("学院")
public class TeachDepartment {
    @ApiModelProperty("uuid")
    String uuid;

    @ApiModelProperty("学院名")
    String departmentName;

    @ApiModelProperty("学院图标")
    String departmentIcon;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

package com.boot.teach.model.school;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("学校")
public class TeachSchool {
    @ApiModelProperty("uuid")
    String uuid;

    @ApiModelProperty("学校名")
    String schoolName;

    @ApiModelProperty("学校地址")
    String schoolAddress;

    @ApiModelProperty("学校图标")
    String schoolIcon;

    @ApiModelProperty("学校等级")
    String schoolDegree;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

package com.boot.teach.model.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("学生课程收藏")
public class StudentStoreCourse {
    @ApiModelProperty("uuid")
    String uuid;

    @ApiModelProperty("课程uid")
    String courseUid;

    @ApiModelProperty("课程收藏状态:0：收藏，1：删除，2：彻底删除--包括所有的记录")
    int storeState;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

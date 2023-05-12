package com.boot.teach.model.course;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "课程申请")
public class CourseApply {
    @ApiModelProperty(value = "uuid")
    String uuid;

    @ApiModelProperty(value = "课程名")
    String courseName;

    @ApiModelProperty(value = "课程所属学院")
    String courseMajor;

    @ApiModelProperty(value = "课程所属班级")
    String courseClass;

    @ApiModelProperty(value = "课程所属学校")
    String courseCollege;

    @ApiModelProperty(value = "课程所属学院")
    String courseDepartment;

    @ApiModelProperty(value = "课程头像")
    String courseIcon;

    @ApiModelProperty(value = "课程描述")
    String courseDesc;

    @ApiModelProperty(value = "课程申请结果原因")
    String courseResultDesc;

    @ApiModelProperty(value = "课程状态，0：上架，1：下架，2：申请中，3，申请通过，4：驳回，5：删除")
    int courseState;

    @ApiModelProperty(value = "创建时间")
    Date createTime;

    @ApiModelProperty(value = "更新时间")
    Date updateTime;
}

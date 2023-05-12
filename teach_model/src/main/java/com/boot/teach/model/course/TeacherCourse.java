package com.boot.teach.model.course;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "教师课程")
public class TeacherCourse {
    @ApiModelProperty(value = "uuid")
    String uuid;

    @ApiModelProperty(value = "教师uid")
    String courseTeacherUid;

    @ApiModelProperty(value = "课程描述")
    String courseDesc;

    @ApiModelProperty(value = "课程大纲")
    String courseSummary;

    @ApiModelProperty(value = "课程所属学院")
    String courseDepartment;

    @ApiModelProperty(value = "课程所属专业")
    String courseMajor;

    @ApiModelProperty(value = "课程所属学校")
    String courseCollege;

    @ApiModelProperty(value = "课程显示：0:上架 1:下架")
    int courseState;

    @ApiModelProperty(value = "课程图片")
    String courseIcon;

    @ApiModelProperty(value = "课程开始时间")
    Date courseBeginTime;

    @ApiModelProperty(value = "课程结束时间")
    Date courseEndTime;

    @ApiModelProperty(value = "课程显示状态，0：所有人可见，1：课程学生可见")
    int courseShow;

    @ApiModelProperty(value = "创建时间")
    Date createTime;

    @ApiModelProperty(value = "更新时间")
    Date updateTime;
}

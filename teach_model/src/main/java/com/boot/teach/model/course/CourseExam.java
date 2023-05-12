package com.boot.teach.model.course;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "课程考试")
public class CourseExam {
    @ApiModelProperty(value = "uid")
    String uuid;

    @ApiModelProperty(value = "考试名称")
    String courseExamName;

    @ApiModelProperty(value = "考试班级")
    String courseExamClass;

    @ApiModelProperty(value = "考试描述")
    String courseExamDesc;

    @ApiModelProperty(value = "考试学校")
    String courseExamCollege;

    @ApiModelProperty(value = "课程教师名")
    String courseExamTeacher;

    @ApiModelProperty(value = "课程所在专业")
    String courseExamMajor;

    @ApiModelProperty(value = "课程考试时长，以分钟显示")
    int courseExamTime;

    @ApiModelProperty(value = "课程考试等级")
    String courseExamLevel;

    @ApiModelProperty(value = "课程考试状态，0:已发布，1：撤回，2：删除")
    int courseExamState;

    @ApiModelProperty(value = "考试等级uid")
    String courseLevelUid;

    @ApiModelProperty(value = "考试简答题数量")
    int courseExamBrief;

    @ApiModelProperty(value = "考试选择题数量")
    int courseExamChoice;

    @ApiModelProperty(value = "考试判断题数量")
    int courseExamCheck;

    @ApiModelProperty(value = "考试总的分数")
    double courseExamScore;

    @ApiModelProperty(value = "开始开始时间")
    Date courseStartTime;

    @ApiModelProperty(value = "开始结束时间")
    Date courseEndTime;

    @ApiModelProperty(value = "创建时间")
    Date createTime;

    @ApiModelProperty(value = "修改时间")
    Date updateTime;
}

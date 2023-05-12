package com.boot.teach.model.course;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("课程视频")
public class CourseVedio {
    @ApiModelProperty("uid")
    String uuid;

    @ApiModelProperty("视频文件名")
    String courseVedioName;

    @ApiModelProperty("视频存储路径")
    String courseVedioUrl;

    @ApiModelProperty("上传者")
    String courseVedioUpload;

    @ApiModelProperty("文件类型")
    String courseVedioType;

    @ApiModelProperty("文件大小")
    String courseVedioSize;

    @ApiModelProperty("课程uid")
    String courseUid;

    @ApiModelProperty("课程视频上传者uid")
    String courseVedioUploadUid;

    @ApiModelProperty("视频描述")
    String courseVedioDesc;

    @ApiModelProperty("视频状态")
    String courseVedioState;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

package com.boot.teach.model.course;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("课程文件")
public class CourseFile {
    @ApiModelProperty("uid")
    String uuid;

    @ApiModelProperty("文件名")
    String courseFileName;

    @ApiModelProperty("文件上传者")
    String courseFileUpload;

    @ApiModelProperty("文件路径")
    String courseFileUrl;

    @ApiModelProperty("文件类型")
    String courseFileType;

    @ApiModelProperty("文件上传者uid")
    String courseFileUploadUid;

    @ApiModelProperty("课程uid")
    String courseUid;

    @ApiModelProperty("文件描述")
    String courseFileDesc;

    @ApiModelProperty("课程文件状态")
    String courseFileState;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date updateTime;
}

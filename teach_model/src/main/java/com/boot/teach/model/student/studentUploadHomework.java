package com.boot.teach.model.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("作业上传")
public class studentUploadHomework {
    @ApiModelProperty("uid")
    String uuid;

    @ApiModelProperty("上传的作业名")
    String sudentUploadWork;

    @ApiModelProperty("学生uid")
    String sudentUuid;

    @ApiModelProperty("课程uid")
    String courseUid;

    @ApiModelProperty("文件类型")
    String fileType;

    @ApiModelProperty("文件大小")
    String fileSize;

    @ApiModelProperty("创建时间")
    Date createTime;

    @ApiModelProperty("更新时间")
    Date uploadTime;
}

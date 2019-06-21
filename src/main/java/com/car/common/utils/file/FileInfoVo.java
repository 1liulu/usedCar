package com.car.common.utils.file;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 描述
 *
 * @author liujinliang
 * @date 2019/2/15 15:48
 */
public class FileInfoVo {

    private Long fileId;

    private String filePath;

    private Integer fileType;

    private Date uploadDate;

    @JSONField(serialize = false)
    private String originalFileName;

    @JSONField(serialize = false)
    private Integer fileSize;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }
}

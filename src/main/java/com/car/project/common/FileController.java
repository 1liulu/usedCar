package com.car.project.common;

import com.car.common.entity.BaseResponse;
import com.car.common.utils.file.FileInfoVo;
import com.car.common.utils.file.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

/**
 * 文件上传的Controller
 */
@RestController
@Slf4j
public class FileController {

    /**
     * 多文件上传
     */
    @PostMapping( "/api/file/upload")
    @ResponseBody
    public BaseResponse batchUpload(MultipartFile[] file) throws Exception{
        String module ="car";
        List<FileInfoVo> fileList = FileUtil.saveFile(module, file);
        return BaseResponse.of(fileList);
    }



}
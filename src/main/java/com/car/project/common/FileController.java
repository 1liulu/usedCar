package com.car.project.common;

import com.car.common.entity.BaseResponse;
import com.car.common.utils.ZoomImageUtils;
import com.car.framework.config.BeanConfig;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * 文件上传的Controller
 */
@Controller
@Slf4j
public class FileController {

    @Autowired
    private BeanConfig beanConfig;


    /**
     * 多文件上传 主要是使用了MultipartHttpServletRequest和MultipartFile
     */
    @RequestMapping(value = "/api/file/upload", method = RequestMethod.POST)
    @ResponseBody
    public String batchUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        String[] fids = new String[files.size()];
        String pic = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    String fid = +System.currentTimeMillis() + "_" + file.getOriginalFilename().replaceAll("[^0-9a-zA-Z.]+","");
                    pic = fid;
                    fids[i] = beanConfig.filePath+fid;
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(beanConfig.filePath, pic)));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => " + e.getMessage();
                }
            } else {
                return "You failed to upload " + i + " because the file was empty.";
            }
        }
       /* ZoomImageUtils zis = new ZoomImageUtils();
        String picPath = beanConfig.filePath + pic;
        File f2 = new File(picPath);
        long a = f2.length();
        String size = "";
        DecimalFormat df = new DecimalFormat("#.00");
        if (a < 1024) {
            size = df.format((double) a) + "BT";
        } else if (a > 102400 && a < 1048576) {
            zis.zoomImage(picPath, picPath, 2);
            size = df.format((double) a / 1024) + "KB";
        } else if (a < 1073741824) {
            zis.zoomImage(picPath, picPath, 3);
            size = df.format((double) a / 1048576) + "MB";
        }*/


        return BaseResponse.of(beanConfig.filePath+fids).toString();
    }


    @RequestMapping(value = "/api/file/view", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> downloadFile(String id, String size)
    {
        if(Strings.isNullOrEmpty(id)){
            return null;
        }
        try {
            String filePath;
            FileSystemResource file = null;
            if (size != null) {
//                filePath = beanConfig.filePath + id;
                filePath = id;
                file = new FileSystemResource(filePath);
            } else {
                //此处，如果图片是大图的话，保留此处的代码，将下面的代码关闭掉
                File f = new File(beanConfig.filePath + id);
                long length = f.length();
                if (length >= 1048576) {
                    ZoomImageUtils ziu = new ZoomImageUtils();
                    ziu.zoomImage(beanConfig.filePath + id, beanConfig.smallPath + id, 2);
                    filePath = beanConfig.smallPath + id;
                    file = new FileSystemResource(filePath);
                } else if (length < 1048576) {
                    filePath = beanConfig.filePath + id;
                    file = new FileSystemResource(filePath);
                }

                //此处，如果图片上是小图的话就开启，关闭上面的代码
           /* filePath = beanConfig.filePath + id;
            file = new FileSystemResource(filePath);*/
            }
            if (file.exists()) {
                HttpHeaders headers = new HttpHeaders();
                headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
                headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
                headers.add("Pragma", "no-cache");
                headers.add("Expires", "0");


                return ResponseEntity
                        .ok()
                        .headers(headers)
                        .contentLength(file.contentLength())
                        .contentType(MediaType.parseMediaType("application/octet-stream"))
                        .body(new InputStreamResource(file.getInputStream()));
            }
        }catch ( Exception e){
            log.info(e.getMessage());
        }
        log.info("file not found :{}", id);
        return null;


    }
}
package com.car.common.utils.file;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述
 *
 * @author
 * @date 2018/6/5 10:52
 */
public class FileUtil {

    public static final Logger log = LoggerFactory.getLogger(FileUtil.class);

    private static String fileSavePath;

    /**
     * 默认大小 50M
     */
    public static final long DEFAULT_MAX_SIZE = 50 * 1024 * 1024;

    /**
     * 默认的文件名最大长度 100
     */
    public static final int DEFAULT_FILE_NAME_LENGTH = 100;

    public static void setFileSavePath(String fileSavePath) {
        FileUtil.fileSavePath = fileSavePath;
    }
    /**
     * http下载
     *
     * @param data
     * @param filename
     * @return
     * @throws Exception
     */
    public static ResponseEntity<byte[]> httpDownload(byte[] data, String filename) throws Exception {
        //请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode(filename) );
        //加引号解决火狐下载文件名乱码问题
        httpHeaders.set("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + URLEncoder.encode(filename));
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //请求状态
        HttpStatus statusCode = HttpStatus.OK;
        //response封装
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(data, httpHeaders, statusCode);
        return responseEntity;
    }

    /**
     * http下载
     *
     * @param file
     * @param filename
     * @return
     * @throws Exception
     */
    public static ResponseEntity<byte[]> httpDownload(File file, String filename) throws Exception {
        return httpDownload(org.apache.commons.io.FileUtils.readFileToByteArray(file), filename);
    }

    public static byte[] readBytes(String path) throws Exception {
        ObjectUtils.checkNotBlank(path);

        InputStream is = FileUtil.class.getClassLoader().getResourceAsStream(path);
        return IOUtils.toByteArray(is);
    }

    //获取文件后缀
    public static String getFileSuffix(String filename) throws Exception {
        Integer spotIndex = filename.lastIndexOf(".");
        return filename.substring(spotIndex + 1);
    }

    //获取文件名称
    public static String getFileName(String filePath) throws Exception {
        int lastSlash = filePath.lastIndexOf("/");
        int lastSpot = filePath.lastIndexOf(".");
        return filePath.substring(lastSlash + 1, lastSpot);
    }

    //拼接路径
    public static String concatFilePath(String path1, String path2) {
        StringBuilder sb = new StringBuilder();
        if (path1.endsWith("/")) {
            path1 = path1.substring(0, path1.length() - 1);
        }
        sb.append(path1);
        if (!path2.startsWith("/")) {
            sb.append("/");
        }
        sb.append(path2);
        return sb.toString();
    }

    //保存文件
    public static List<FileInfoVo> saveFile(String module, MultipartFile[] fileArr) throws Exception {
        List<FileInfoVo> resultList = new ArrayList<>();
        for (MultipartFile file : fileArr) {
            if (!file.isEmpty()) {
                FileInfoVo fileInfoVo = saveFileAction(module, file);
                resultList.add(fileInfoVo);
            }
        }
        return resultList;
    }

    //保存文件
    public static FileInfoVo saveFileAction(String module, MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        Date localDate = new Date();
        String yyyyMMdd = DateUtils.dateToString(localDate, DateUtils.YYYY_MM_DD);
        String targetFolder = "/" + module + "/" + yyyyMMdd + "/";
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        Long fileId = IdWorker.getRandomNextId();
        String genFileName = fileId.toString() + "." + suffix;

        if (fileSavePath.endsWith("/")) {
            fileSavePath = fileSavePath.substring(0, fileSavePath.length() - 1);
        }

        //创建目录
        StringBuilder saveFolderSb = new StringBuilder();
        saveFolderSb.append(fileSavePath);
        saveFolderSb.append(targetFolder);
        String saveFolder = saveFolderSb.toString();
        File saveFileFolder = new File(saveFolder);
        if (!saveFileFolder.exists() && !saveFileFolder.isDirectory()) {
            log.info("目录[{}]不存在, 创建目录", saveFolder);
            saveFileFolder.mkdirs();
        }

        saveFolderSb.append(genFileName);
        //完整路径
        String fullFilePath = saveFolderSb.toString();

        StringBuilder filePathSb = new StringBuilder();
        filePathSb.append(targetFolder).append(genFileName);

        log.info("保存文件[{}]...", fullFilePath);
        final File targetFile = new File(fullFilePath);
        //保存
        try {
            file.transferTo(targetFile);
            log.info("文件[{}]保存成功", fullFilePath);
            FileInfoVo fileInfoVo = new FileInfoVo();
            fileInfoVo.setFileId(fileId);
            fileInfoVo.setOriginalFileName(fileName);
            fileInfoVo.setFilePath(new StringBuilder().append(targetFolder).append(genFileName).toString());
            fileInfoVo.setFileSize(Long.valueOf(file.getSize()).intValue());
            fileInfoVo.setUploadDate(localDate);
            return fileInfoVo;
        } catch (Exception e) {
            log.error("文件[{}]保存失败", fullFilePath);
            log.error("异常: ", e);
            return null;
        }
    }



    /**
     * 文件上传
     *
     * @param baseDir   相对应用的基目录
     * @param file      上传的文件
     * @param extension 上传文件类型
     * @return 返回上传成功的文件名
     * @throws FileSizeLimitExceededException       如果超出最大大小
     * @throws
     * @throws IOException                          比如读写文件出错时
     */
    public static final FileInfoVo upload(String baseDir, MultipartFile file, String extension)
            throws FileSizeLimitExceededException, IOException {

        int fileNamelength = file.getOriginalFilename().length();
        Long fileId = IdWorker.getRandomNextId();
        assertAllowed(file);

        // String fileName = file.getOriginalFilename();

        File desc = getAbsoluteFile(baseDir, baseDir + "\\" + fileId + extension);
        file.transferTo(desc);
        FileInfoVo fileInfoVo = new FileInfoVo();
        fileInfoVo.setFileId(fileId);
        fileInfoVo.setOriginalFileName(fileId + extension);
        fileInfoVo.setFilePath(baseDir + "\\" + fileId + extension);
        fileInfoVo.setFileSize(fileNamelength);
        fileInfoVo.setUploadDate(new Date());

        return fileInfoVo;
    }

    /**
     * 文件大小校验
     *
     * @param file 上传的文件
     * @return
     * @throws FileSizeLimitExceededException 如果超出最大大小
     */
    public static final void assertAllowed(MultipartFile file) throws FileSizeLimitExceededException {
        long size = file.getSize();
    }

    private static final File getAbsoluteFile(String uploadDir, String filename) throws IOException {
        File desc = new File(File.separator + filename);

        if (!desc.getParentFile().exists()) {
            desc.getParentFile().mkdirs();
        }
        if (!desc.exists()) {
            desc.createNewFile();
        }
        return desc;
    }







}

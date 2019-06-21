package com.car.framework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

@Configuration
public class BeanConfig {

    //    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters() {
//        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
//                SerializerFeature.WriteNullStringAsEmpty,
//                SerializerFeature.WriteNullNumberAsZero,
//                SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.DisableCheckSpecialChar);
//        fastJsonConfig.setDateFormat("yyyy-MM-dd hh:mm:ss");
//        //处理中文乱码问题
//        List<MediaType> fastMediaTypes = new ArrayList<>();
//        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        fastConvert.setSupportedMediaTypes(fastMediaTypes);
//        fastConvert.setFastJsonConfig(fastJsonConfig);
//        return new HttpMessageConverters((HttpMessageConverter<?>) fastConvert);
//    }
    @Value("${file.tempPath}")
    private String tempPath;

    @Value("${file.filePath}")
    public String filePath;

    @Value("${file.smallPath}")
    public String smallPath;

    @Value("${file.testPath}")
    public String testPath;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件大小限制 ,超出设置页面会抛出异常信息，
        // 这样在文件上传的地方就需要进行异常信息的处理了;
        factory.setMaxFileSize("10MB"); // KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("50MB");
        // Sets the directory location where files will be stored.
        factory.setLocation(tempPath);
        return factory.createMultipartConfig();
    }
}

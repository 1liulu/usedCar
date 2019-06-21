package com.car.project.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 描述
 *
 * @author liulu
 * @date 2019/6/21 14:27
 */

@Configuration
@ConfigurationProperties(prefix = "file")
@Data
public class FileProperties {
    private String filePath;

}

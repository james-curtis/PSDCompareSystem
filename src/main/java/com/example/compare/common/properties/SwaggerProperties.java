package com.example.compare.common.properties;

import lombok.Data;

/**
 * Swagger配置参数
 *
 * @author 朱涵
 * @date 2021/3/18
 */

@Data
public class SwaggerProperties {

    private String basePackage;
    private String title;
    private String description;
    private String author;
    private String url;
    private String email;
    private String version;

}

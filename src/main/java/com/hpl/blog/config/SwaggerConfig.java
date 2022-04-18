package com.hpl.blog.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/1 10:58
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // swagger插件
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("HHHZBlog")
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }


    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("HHHZBlog网站-API文档")
                .description("本文档描述了HHHZBlog微服务接口的定义")
                .version("1.0")
                .contact(new Contact("hpl", "http://hpl.com", "243031504@qq.com"))
                .build();
    }

}

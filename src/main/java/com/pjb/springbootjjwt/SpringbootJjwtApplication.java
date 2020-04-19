package com.pjb.springbootjjwt;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UrlPathHelper;
//import org.apache.tomcat.util.buf. UDecoder.ALLOW_ENCODED_SLASH
//import org.apache.catalina.connector.CoyoteAdapter.ALLOW_BACKSLASH
//@SpringBootApplication
@MapperScan("com.pjb.springbootjjwt.mapper")
//public class SpringbootJjwtApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(SpringbootJjwtApplication.class, args);
//    }
//}

@SpringBootApplication
class SpringbootJjwtApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) throws Exception {
        System.setProperty("org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH", "true");
        SpringApplication.run(SpringbootJjwtApplication.class, args);
    }
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setUrlDecode(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
}




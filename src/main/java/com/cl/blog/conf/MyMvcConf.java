package com.cl.blog.conf;

import com.cl.blog.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConf implements WebMvcConfigurer {
    // @Override
/*    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/main.html").setViewName("admin/login");
    }
   */

  @Bean
    public WebMvcConfigurer webMvcConfigurerAdapter(){
      WebMvcConfigurer conf=new WebMvcConfigurer(){
        @Override
        public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/main.html").setViewName("admin/login");
        registry.addViewController("/ResetPwd.html").setViewName("admin/success");
        registry.addViewController("/logSuccess.html").setViewName("admin/manage/LoginSuccess");
        registry.addViewController("edit.html").setViewName("admin/Edit");
        registry.addViewController("manage.html").setViewName("admin/manage/index");
        registry.addViewController("WriteArticle.html").setViewName("admin/manage/WriteArticle");
        registry.addViewController("index.html").setViewName("pages/index");
        registry.addViewController("/SelfIntrodution.html").setViewName("pages/SelfIntrodution");
        registry.addViewController("/shares.html").setViewName("pages/shares");
        registry.addViewController("/LeftMessage.html").setViewName("pages/LeftMessage");
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
          registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/logSuccess.html").addPathPatterns("/edit.html");
        }
      };
    return conf;
  }
}

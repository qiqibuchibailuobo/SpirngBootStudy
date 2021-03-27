package cn.yq.demo.config;

import cn.yq.demo.config.accesslog.AccessLogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 拦截器的注册
 */
@Configuration
//废弃：public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter{
public class MyWebMvcConfigurer implements WebMvcConfigurer {

  //设置排除路径，spring boot 2.*，注意排除掉静态资源的路径，不然静态资源无法访问
  private final String[] excludePath = {"/static"};

  @Resource
  CustomHandlerInterceptor customHandlerInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
     //注册拦截器 拦截规则
    //多个拦截器时 以此添加 执行顺序按添加顺序
//    registry.addInterceptor(customHandlerInterceptor).addPathPatterns("/*");

    registry.addInterceptor(new AccessLogInterceptor())
            .addPathPatterns("/**")
            .excludePathPatterns(excludePath);
  }
   

}
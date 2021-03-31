package cn.yq.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication()
@MapperScan(basePackages = {"cn.yq.demo.generator"})
@ServletComponentScan
@EnableRedisRepositories
@EnableCaching
public class DemoApplication {

    public static void main(String[] args) {
        //下面语句使得Log4j2日志输出使用异步处理，减小输出日志对性能的影响
//        System.setProperty("Log4jContextSelector",
//                "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(DemoApplication.class, args);
    }

}

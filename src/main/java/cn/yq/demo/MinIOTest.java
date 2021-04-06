package cn.yq.demo;

import cn.yq.demo.utils.MinIOTemplate;
import io.minio.ObjectWriteResponse;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MinIOTest {

  @Resource
  MinIOTemplate minTemplate;

  //测试创建bucket
  @Test
  public void testCreateBucket() throws Exception {
    minTemplate.makeBucket("test");
  }

  //测试上传文件对象
  @Test
  public void testPutObject() throws Exception {
    ObjectWriteResponse response = minTemplate.putObject("test",
            "base/springboot青铜到王者封面.png",
            "D:\\testFileUp\\2021\\04\\06\\1.png");
    System.out.println(response.object());
  }

  //测试删除文件对象
  @Test
  public void testDeleteObject() throws Exception {
    minTemplate.removeObject("test",
            "base/springboot青铜到王者封面.png");
  }
}
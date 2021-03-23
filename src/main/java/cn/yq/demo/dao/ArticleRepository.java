package cn.yq.demo.dao;

import cn.yq.demo.generator.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="articles")   //就是这一行神奇的代码，甚至这一行都可以不写
public interface ArticleRepository extends JpaRepository<Article,Integer> {
    Article findByAuthor(@Param("author") String author);
}
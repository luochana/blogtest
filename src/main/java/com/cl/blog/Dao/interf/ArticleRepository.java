package com.cl.blog.Dao.interf;

import com.cl.blog.Dao.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Integer> {
}

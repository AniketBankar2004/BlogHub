package com.example.aniket.Bloghub.repo;

import com.example.aniket.Bloghub.models.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepo extends MongoRepository<Blog,String> {

}

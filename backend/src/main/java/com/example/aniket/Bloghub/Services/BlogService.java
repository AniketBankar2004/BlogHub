package com.example.aniket.Bloghub.Services;

import com.example.aniket.Bloghub.models.Blog;
import com.example.aniket.Bloghub.repo.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepo repo;

    public void addBlog(Blog blog){
        repo.save(blog);

    }

    public Boolean deleteBlog(String blogId){
        if (repo.existsById(blogId)){
            repo.deleteById(blogId);
            return true;
        }
        return false;
    }

    public boolean updateBlog(String blogId, Blog updatedBlog) {
        Optional<Blog> optionalBlog = repo.findById(blogId);

        if (optionalBlog.isPresent()) {
            Blog existingBlog = optionalBlog.get();

            existingBlog.setTitle(updatedBlog.getTitle());
            existingBlog.setContent(updatedBlog.getContent());
            repo.save(existingBlog);
            return true;
        } else {
            return false;
        }
    }
    public List<Blog> getBlogs(){
        return repo.findAll();
    }
}

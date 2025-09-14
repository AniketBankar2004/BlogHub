package com.example.aniket.Bloghub.controller;


import com.example.aniket.Bloghub.Services.BlogService;
import com.example.aniket.Bloghub.models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class BlogController {


    private final BlogService service;

    public BlogController(BlogService service){
        this.service = service;
    }

    @DeleteMapping("/blogs/{blogId}")
    public ResponseEntity<String>deleteBlog(@PathVariable String blogId){
        try{
            boolean deleted = service.deleteBlog(blogId);

            if (deleted){
                return new ResponseEntity<>("Blog Deleted Successfully",HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Blog with id "+blogId+" not found" ,HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error Deleting blog",HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/blogs/{blogId}")
    public ResponseEntity<String> updateBlog(@PathVariable String blogId,
                                             @RequestBody Blog updatedBlog){
        try{
           Boolean isUpdated = service.updateBlog(blogId,updatedBlog);

           if (isUpdated){
               return new ResponseEntity<>("Blog updated successfully",HttpStatus.OK);
            }
           else{
               return new ResponseEntity<>("Blog with id "+blogId +" not found",HttpStatus.NOT_FOUND);
           }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error updating the Blog",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/blogs")
    public ResponseEntity<?>addBlog (@RequestBody Blog blog){
        System.out.println(blog);
        try {
            service.addBlog(blog);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/blogs")
    public List<Blog> getBlogs(){
        return service.getBlogs();
    }
}

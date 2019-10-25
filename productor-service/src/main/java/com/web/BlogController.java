package com.web;

import com.bean.Blog;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class BlogController {

    @RequestMapping("/blog/{title}")
    public Blog findById(@PathVariable("title") String title){
        return new Blog(title,"沈石溪");
    }

    @RequestMapping("/blog/findList")
    public List<Blog> findList(){
        return Arrays.asList(new Blog("博客1", "作者1"),
                new Blog("博客2", "作者2"),
                new Blog("博客3", "作者3"),
                new Blog("博客4", "作者4"));
    }
}

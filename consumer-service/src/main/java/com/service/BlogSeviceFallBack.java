package com.service;

import com.bean.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogSeviceFallBack implements BlogService{
    @Override
    public Blog findByTitle(String title) {
        return new Blog("服务器挂了","");
    }

    @Override
    public List<Blog> findL() {
        return new ArrayList<>();
    }
}

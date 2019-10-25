package com.service;

import com.bean.Blog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name="producer-service",fallback = BlogSeviceFallBack.class)//name属性必须是服务的名称
public interface BlogService {
    @RequestMapping("/blog/{title}")
    Blog findByTitle(@PathVariable("title") String title);

    @RequestMapping("/blog/findList")
    List<Blog> findL();
}

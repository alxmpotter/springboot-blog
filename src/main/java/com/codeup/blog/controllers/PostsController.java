package com.codeup.blog.controllers;

import com.codeup.blog.controllers.services.PostSvc;
import com.codeup.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostsController {
    private final PostSvc postSvc;

    @Autowired
    public PostsController(PostSvc postSvc){
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String showAll(Model viewModel){

        List<Post> posts = postSvc.findAll();
        viewModel.addAttribute("posts", posts);

        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable int id, Model viewModel){

        Post post = postSvc.findOne(id);
        viewModel.addAttribute("post", post);

        return "posts/show";
    }


    @GetMapping("/posts/create")
    public String createPostForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
      postSvc.savePost(post);

      return "redirect:/posts";
    }
}

package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostsController {


    @GetMapping("/posts")
    public String showAll(Model viewModel){

        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post("Example 1", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!"));

        posts.add(new Post("Example 2", "QWE Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!"));



        viewModel.addAttribute("posts", posts);

        return "posts/index";
    }



    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable int id, Model viewModel){
        Post post = new Post("Example 1", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!");

        viewModel.addAttribute("post", post);
        return "posts/show";
    }


    @GetMapping("/posts/create")
    public String createPostForm(){
        return "view the form for creating a post";
    }


    @PostMapping("/posts/create")
    public String createPost(){
        return "create a new post";
    }
}

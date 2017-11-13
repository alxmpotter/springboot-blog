package com.codeup.blog.controllers;

import com.codeup.blog.controllers.services.PostSvc;
import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostsController {
    private final PostSvc postSvc;
    private final UsersRepository usersDao;

    @Autowired
    ///constructor injection of repository through the service class
    public PostsController(PostSvc postSvc, UsersRepository usersDao){
        this.postSvc = postSvc;
        this.usersDao = usersDao;

    }

    @GetMapping("/posts")
    public String showAll(Model viewModel){

        List<Post> posts = postSvc.showAllPosts();
        viewModel.addAttribute("posts", posts);

        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable int id, Model viewModel){

        Post post = postSvc.findById(id);
        viewModel.addAttribute("post", post);

        return "posts/show";
    }


    @GetMapping("/posts/create")
    public String createPostForm(Model viewModel){
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String publishPost(
            @Valid Post post,
            Errors validation,
            Model model
    ) {
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }

        User user = usersDao.findOne(2L);
        post.setUser(user);
        postSvc.savePosts(post);

        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable int id, Model vModel){
        vModel.addAttribute("post", postSvc.findById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @ModelAttribute Post post) {
        post.setId(id);
        postSvc.savePosts(post);
        return "redirect:/posts/" + post.getId();
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postSvc.delete(id);
        return "redirect:/posts/";
    }


}

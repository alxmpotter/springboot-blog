package com.codeup.blog.controllers.services;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("postSvc")
public class PostSvc {
    private List<Post> posts;

    public PostSvc(){
        this.posts = new ArrayList<>();
        createDummyPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post findOne(long id) {
        return posts.get((int) (id - 1));
    }

    public Post savePost(Post post) {
        post.setId((long) posts.size() + 1);
        posts.add(post);
        return post;
    }

    public void createDummyPosts() {

        this.savePost(new Post("Post One", "blah blah blah blah blah"));

        this.savePost(new Post("Post Two", "blah blah blah blah blah"));

        this.savePost(new Post("Post Three", "blah blah blah blah blah"));
    }

}

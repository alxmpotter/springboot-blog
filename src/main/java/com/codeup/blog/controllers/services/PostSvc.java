package com.codeup.blog.controllers.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("postSvc")
public class PostSvc {

    private final PostRepository postsDao;

    @Autowired
    public PostSvc(PostRepository postsDao) {
        this.postsDao = postsDao;
//        createDummyPosts(); calls the list from the method below
    }

//////type cast the object with the data type you need the .findAll is whats being called from the repository
/////looking for an Iterable (which is a superclass of list, more generic) but the data type is list
    public List<Post> showAllPosts() {
        return (List<Post>) postsDao.findAll();
    }

    public Post findById(long id) {
        return postsDao.findOne(id);
    }

    public Post savePosts(Post post) {
        postsDao.save(post);
        return post;
    }

    public void delete(long id) {
        postsDao.delete(id);
    }

//dummy posts for when you don't have a database but you need to build a project.
//////////
//    public void createDummyPosts() {
//
//        savePost(new Post("Post One", "blah blah blah blah blah"));
//
//        this.savePost(new Post("Post Two", "blah blah blah blah blah"));
//
//        this.savePost(new Post("Post Three", "blah blah blah blah blah"));
//    }

}

package com.ragaslan.rest.service.impl;

import com.ragaslan.rest.dao.PostDAO;
import com.ragaslan.rest.entity.Post;
import com.ragaslan.rest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    @Autowired
    public PostServiceImpl(PostDAO postDAO){
        this.postDAO = postDAO;
    }

    @Override
    public List<Post> findAll(){
        return postDAO.findAll();
    }

    @Override
    public Post findById(Integer id){
        return postDAO.findById(id);
    }

    @Override
    @Transactional
    public Post create(Post thePost){
        postDAO.save(thePost);
        return thePost;
    }

    @Override
    @Transactional
    public void deleteById(Integer id){
        postDAO.delete(id);
    }

    @Override
    @Transactional
    public Post updateById(Integer id,Post thePost){
        Post updatedPost = postDAO.findById(id);

        if (updatedPost == null){
            throw new RuntimeException("There is no post with this id !");
        }

        updatedPost.setAuthor(thePost.getAuthor());
        updatedPost.setContent(thePost.getContent());
        updatedPost.setCreatedAt(thePost.getCreatedAt());
        updatedPost.setTitle(thePost.getTitle());

        postDAO.update(updatedPost);
        return updatedPost;

    }
}

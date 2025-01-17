package com.ragaslan.rest.service.impl;

import com.ragaslan.rest.dao.PostDAO;
import com.ragaslan.rest.dao.PostTagDAO;
import com.ragaslan.rest.entity.Language;
import com.ragaslan.rest.entity.Post;
import com.ragaslan.rest.entity.PostTag;
import com.ragaslan.rest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;
    private final PostTagDAO postTagDAO;

    @Autowired
    public PostServiceImpl(PostDAO postDAO,PostTagDAO postTagDAO){
        this.postDAO = postDAO;
        this.postTagDAO = postTagDAO;
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
    public List<PostTag> getAllTags(Integer id){
        Post thePost = postDAO.findById(id);
        if(thePost == null){
            throw new RuntimeException("There is no post with this post id !");
        }

        return thePost.getTags();
    }

    @Override
    @Transactional
    public List<PostTag> addTag(Integer id,PostTag theTag){
        Post thePost = postDAO.findById(id);
        if(thePost == null){
            throw new RuntimeException("There is no post with this post id !");
        }
        PostTag tagSearch = postTagDAO.findByName(theTag.getName());
        if(tagSearch == null){
            theTag.setPosts(new ArrayList<Post>());
            theTag.getPosts().add(thePost);
            postTagDAO.save(theTag);
            thePost.getTags().add(theTag);
        }else{
            // this branch says there is a tag name with theTag.name from request body
            // we have to check tags in thePost to avoid duplicate tags
            if(tagSearch.getPosts().contains(thePost)){
                throw new RuntimeException("This post have already this tag !");
            }
            tagSearch.getPosts().add(thePost);
            postTagDAO.update(tagSearch);
            thePost.getTags().add(tagSearch);
        }
        postDAO.update(thePost);
        return thePost.getTags();
    }

    @Override
    @Transactional
    public Post create(Post thePost){
        postDAO.save(thePost);
        return thePost;
    }

    @Override
    public Post findBySlug(String slug) {
        return postDAO.findBySlug(slug);

    }

    @Override
    @Transactional
    public void deleteById(Integer id){
        Post thePost = postDAO.findById(id);
        if(thePost == null){
            throw new RuntimeException("There is no post with this id !");
        }
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

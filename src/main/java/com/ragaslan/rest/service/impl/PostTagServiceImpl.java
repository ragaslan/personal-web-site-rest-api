package com.ragaslan.rest.service.impl;

import com.ragaslan.rest.dao.PostTagDAO;
import com.ragaslan.rest.entity.PostTag;
import com.ragaslan.rest.service.PostTagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostTagServiceImpl implements PostTagService {

    private final PostTagDAO postTagDAO;

    public PostTagServiceImpl(PostTagDAO postTagDAO){
        this.postTagDAO = postTagDAO;
    }

    @Override
    public List<PostTag> findAll(){
        return postTagDAO.findAll();
    }

    @Override
    public PostTag findById(Integer id){
        return postTagDAO.findById(id);
    }

    @Override
    @Transactional
    public PostTag create(PostTag thePostTag){
        postTagDAO.save(thePostTag);
        return thePostTag;
    }

    @Override
    @Transactional
    public void deleteById(Integer id){
        postTagDAO.delete(id);
    }

    @Override
    @Transactional
    public PostTag updateById(Integer id,PostTag thePostTag){
        PostTag updatedPostTag = postTagDAO.findById(id);
        if(updatedPostTag == null){
            throw new RuntimeException("There is no tag with this tag id");
        }
        updatedPostTag.setName(thePostTag.getName());
        postTagDAO.update(updatedPostTag);
        return updatedPostTag;
    }

}

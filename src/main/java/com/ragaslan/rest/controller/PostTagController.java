package com.ragaslan.rest.controller;


import com.ragaslan.rest.entity.PostTag;
import com.ragaslan.rest.service.PostTagService;
import com.ragaslan.rest.dto.PostTagDTO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tags")
public class PostTagController {

    private final PostTagService postTagService;

    @Autowired
    public PostTagController(PostTagService postTagService){
        this.postTagService = postTagService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PostTag>> findAll(){
        List<PostTag> tags = postTagService.findAll();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostTag> findOne(@PathVariable Integer id){
        PostTag thePostTag = postTagService.findById(id);
        if(thePostTag == null){
            throw new RuntimeException("There is no tag with this tag id.");
        }
        return new ResponseEntity<>(thePostTag,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<PostTag> create(@Valid @RequestBody PostTagDTO thePostTag){
        ModelMapper mapper = new ModelMapper();
        PostTag newPost = mapper.map(thePostTag,PostTag.class);
        PostTag createdPost = postTagService.create(newPost);
        return new ResponseEntity<>(createdPost,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        PostTag thePostTag = postTagService.findById(id);
        if(thePostTag == null){
            throw new RuntimeException("There is no tag with this tag id");
        }
        postTagService.deleteById(thePostTag.getId());
        return new ResponseEntity<>("Tag is deleted succesfully !",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostTag> update(@PathVariable Integer id,@Valid @RequestBody PostTagDTO requestObject){
        ModelMapper mapper = new ModelMapper();
        PostTag thePostTag = mapper.map(requestObject,PostTag.class);
        PostTag updatedTag = postTagService.updateById(id,thePostTag);
        return new ResponseEntity<>(updatedTag,HttpStatus.OK);
    }


}

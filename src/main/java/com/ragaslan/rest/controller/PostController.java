package com.ragaslan.rest.controller;

import com.ragaslan.rest.entity.Post;
import com.ragaslan.rest.service.PostService;
import dto.PostDTO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Post>> findAll(){
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findOne(@PathVariable Integer id){
        Post thePost = postService.findById(id);
        if(thePost == null){
            throw new RuntimeException("There is no post with this post id.");
        }
        return new ResponseEntity<>(thePost,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Post> create(@Valid @RequestBody PostDTO thePost){
        ModelMapper mapper = new ModelMapper();
        Post newPost = mapper.map(thePost,Post.class);
        Post createdPost = postService.create(newPost);
        return new ResponseEntity<>(createdPost,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Post thePost = postService.findById(id);
        if(thePost == null){
            throw new RuntimeException("There is no post with this post id");
        }
        postService.deleteById(thePost.getId());
        return new ResponseEntity<>("The post is deleted successfully !",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable Integer id,@RequestBody PostDTO requestObject){
        ModelMapper mapper = new ModelMapper();
        Post thePost = mapper.map(requestObject,Post.class);
        Post updatedPost = postService.updateById(id,thePost);
        return new ResponseEntity<>(updatedPost,HttpStatus.OK);
    }


}

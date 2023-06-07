package com.lucasmont.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucasmont.workshopmongo.domain.Post;
import com.lucasmont.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
   
    @Autowired
    private PostService service;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll(){
        List<Post> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}

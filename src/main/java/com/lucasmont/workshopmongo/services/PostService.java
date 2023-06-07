package com.lucasmont.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasmont.workshopmongo.domain.Post;
import com.lucasmont.workshopmongo.repository.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository PostRepository;

    public List<Post> findAll() {
        return PostRepository.findAll();
    }
}

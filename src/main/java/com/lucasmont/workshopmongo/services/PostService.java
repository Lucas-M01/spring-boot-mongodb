package com.lucasmont.workshopmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasmont.workshopmongo.domain.Post;
import com.lucasmont.workshopmongo.repository.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) { 
        Post post = postRepository.findById(id).orElse(null);
        return post;
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}

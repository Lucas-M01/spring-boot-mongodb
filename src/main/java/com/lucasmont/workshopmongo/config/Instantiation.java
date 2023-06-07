package com.lucasmont.workshopmongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucasmont.workshopmongo.domain.Post;
import com.lucasmont.workshopmongo.domain.User;
import com.lucasmont.workshopmongo.dto.AuthorDTO;
import com.lucasmont.workshopmongo.dto.CommentDTO;
import com.lucasmont.workshopmongo.repository.PostRepository;
import com.lucasmont.workshopmongo.repository.UserRepository;
import java.util.Arrays;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-3"));

        userRepository.deleteAll();
        
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018") ,"Aprender Java", "http://www.udemy.com", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("22/04/2018"), "Aprender JavaScript", "http://www.udemy.com", new AuthorDTO(bob));
        
        CommentDTO comment1 = new CommentDTO("Boa postagem", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Comentario muito legal", sdf.parse("22/04/2018"), new AuthorDTO(bob));
        CommentDTO comment3 = new CommentDTO("Comentario muito legal mano", sdf.parse("22/04/2018"), new AuthorDTO(alex));


        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().addAll(Arrays.asList(comment3));
        
        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().add(0, post1);
        userRepository.save(maria);
    }
    
}

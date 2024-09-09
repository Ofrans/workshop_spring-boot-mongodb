package com.compasso.workshopmongo.resources;

import com.compasso.workshopmongo.domain.Post;
import com.compasso.workshopmongo.domain.Post;
import com.compasso.workshopmongo.resources.util.URL;
import com.compasso.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.deCodeParam(text);
        List<Post> posts = service.findByTitle(text);

        return ResponseEntity.ok().body(posts);
    }

}

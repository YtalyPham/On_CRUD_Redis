package com.example.on_redis_crud.controller;

import com.example.on_redis_crud.model.Movie;
import com.example.on_redis_crud.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/")
    public Movie saveMovie(@RequestBody Movie movie){
        movieRepository.saveMovie(movie);
        return movie;
    }

    @GetMapping("/")
    public List<Movie> findAll(){

        return movieRepository.findAll();
    }
    @GetMapping("/{id}")
//    @Cacheable("movies")
    public Movie findById(@PathVariable("id") Integer id){

        return movieRepository.findById(id);
    }

    @PutMapping("/")
    public void update(@RequestBody Movie movie){

        movieRepository.update(movie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        movieRepository.delete(id);
    }
}

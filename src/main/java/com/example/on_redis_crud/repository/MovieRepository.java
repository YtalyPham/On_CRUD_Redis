package com.example.on_redis_crud.repository;

import com.example.on_redis_crud.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class MovieRepository {
    @Autowired
    private HashOperations hashOperations;//crud hash
//    private RedisTemplate redisTemplate;
//
//    public MovieRepository(RedisTemplate redisTemplate) {
//        this.hashOperations = redisTemplate.opsForHash();
//        this.redisTemplate = redisTemplate;
//
//    }

    public void saveMovie(Movie movie){
        hashOperations.put("MOVIETEST1", movie.getId(), movie);
    }
    public List<Movie> findAll(){

        return hashOperations.values("MOVIETEST1");
    }
    public Movie findById(Integer id){

        return (Movie) hashOperations.get("MOVIETEST1", id);
    }

    public void update(Movie movie){
        saveMovie(movie);
    }
    public void delete(Integer id){
        hashOperations.delete("MOVIETEST1", id);
    }
}

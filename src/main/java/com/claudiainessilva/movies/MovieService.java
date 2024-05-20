package com.claudiainessilva.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired // to instantiate MovieRepository class - alternative is to add a constructor
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String  imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}

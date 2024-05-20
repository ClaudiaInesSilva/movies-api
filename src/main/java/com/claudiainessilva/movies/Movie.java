package com.claudiainessilva.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection= "movies") //Spring data MongoDB annotation - This annotation marks a class
// as being a domain object that we want to persist to the database:
@Data //"shortcut" for getters, setters, toString, equals, hashcode...
@AllArgsConstructor // generates a constructor with one parameter for every field in the class
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops; //images to be used in the FE application
    @DocumentReference //MongoDB spring annotation - manual reference and only stores
    // the ID of the linked document in MongoDB
    private List<Review> reviewIds;

}

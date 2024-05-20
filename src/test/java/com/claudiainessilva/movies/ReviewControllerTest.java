package com.claudiainessilva.movies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class ReviewControllerTest {

    @InjectMocks
    ReviewController reviewController;

    @MockBean
    ReviewService serviceReview;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should return HTTP Status 201 Created when a review is successfully created")
    @Test
    void shouldReturnCreatedStatusAndCreateReview() {
        // Arrange
        Map<String, String> payload = new HashMap<>();
        payload.put("reviewBody", "This movie is great!");
        payload.put("imdbId", "123");

        Review review = new Review();
        when(serviceReview.createReview(any(), any())).thenReturn(review);

        // Act
        ResponseEntity<Review> response = reviewController.createReview(payload);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(review, response.getBody());
    }
}
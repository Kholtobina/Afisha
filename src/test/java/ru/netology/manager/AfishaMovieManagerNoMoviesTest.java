package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaMovieManagerNoMoviesTest {

    private AfishaMovieManager manager = new AfishaMovieManager();

    @Test
    public void shouldHaveZeroMovies() {
        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {};
        assertArrayEquals(expected, actual);
    }
}